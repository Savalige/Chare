using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API.Data;
using API.Models;
using Newtonsoft.Json;

namespace API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RequestController : ControllerBase
    {
        private readonly Database _context;

        public RequestController(Database context)
        {
            _context = context;
        }

        // GET: api/Request
        [HttpGet]
        public async Task<ActionResult<IEnumerable<RequestModel>>> GetRequests()
        {
            return await _context.Requests.ToListAsync();
        }

        // GET: api/Request/5
        [HttpGet("{id}")]
        public async Task<ActionResult<RequestModel>> GetRequestModel(int id)
        {
            var requestModel = await _context.Requests.Include(r => r.Rq_Profile).Where(r => r.Rq_Id == id)
                .FirstAsync();

            if (requestModel == null)
            {
                return NotFound();
            }

            return requestModel;
        }

        // PUT: api/Request/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRequestModel(int id, RequestModel requestModel)
        {
            if (id != requestModel.Rq_Id)
            {
                return BadRequest();
            }

            _context.Entry(requestModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!RequestModelExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Request
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<RequestModel>> PostRequestModel([FromForm] string requestdata)
        {
            dynamic m = JsonConvert.DeserializeObject(requestdata);

            RequestModel requestModel = new RequestModel();

            requestModel.Rq_Start = m.rq_Start;
            requestModel.Rq_Destination = m.rq_Destination;
            requestModel.Rq_Price = m.rq_Price;
            requestModel.Rq_Message = m.rq_Message;
            requestModel.Rq_Profile = await _context.Profiles.FindAsync(Convert.ToInt32(m.rq_Profile.pr_Id));

            _context.Requests.Add(requestModel);

            TripModel trip = await _context.Trips.FindAsync(Convert.ToInt32(m.rq_tripID));
            if(trip.Tr_Requests == null)
            {
                trip.Tr_Requests = new List<RequestModel>();
            }
   
            trip.Tr_Requests.Add(requestModel);
            
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRequestModel", new { id = requestModel.Rq_Id }, requestModel);
        }


        // POST: api/Request/Accept/2
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost("Accept/{requestId}/{tripId}")]
        public async Task<ActionResult> AcceptRequestModel(int requestId, int tripId)
        {
            RequestModel rq = await _context.Requests.Include(r => r.Rq_Profile).Where(r => r.Rq_Id == requestId)
               .FirstAsync();


            ApprovedPassengerModel passenger = new ApprovedPassengerModel();
            passenger.AP_Destination = rq.Rq_Destination;
            passenger.AP_Start = rq.Rq_Start;
            passenger.AP_Price = rq.Rq_Price;
            passenger.AP_Passenger = rq.Rq_Profile;
           

            TripModel trip = await _context.Trips.FindAsync(tripId);

            if (trip.Tr_ApprovedPassengers == null)
            {
                trip.Tr_ApprovedPassengers = new List<ApprovedPassengerModel>();
            }

            trip.Tr_ApprovedPassengers.Add(passenger);

            trip.Tr_Requests.Remove(rq);
            
            _context.Requests.Remove(rq);

            await _context.SaveChangesAsync();

            return Ok();
        }

        // POST: api/Request/Deny/2
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost("Deny/{requestId}/{tripId}")]
        public async Task<ActionResult> DenyRequestModel(int requestId, int tripId)
        {
            RequestModel rq = await _context.Requests.Include(r => r.Rq_Profile).Where(r => r.Rq_Id == requestId)
               .FirstAsync();

            TripModel trip = await _context.Trips.FindAsync(tripId);
            DeclinedModel dm = new DeclinedModel();
            dm.Dec_Trip = trip;
            dm.Dec_Profile = rq.Rq_Profile;

            trip.Tr_Requests.Remove(rq);
            _context.Requests.Remove(rq);

            _context.DeclinedRequests.Add(dm);

            await _context.SaveChangesAsync();

            return Ok();
        }

        // DELETE: api/Request/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRequestModel(int id)
        {
            var requestModel = await _context.Requests.FindAsync(id);
            if (requestModel == null)
            {
                return NotFound();
            }

            _context.Requests.Remove(requestModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool RequestModelExists(int id)
        {
            return _context.Requests.Any(e => e.Rq_Id == id);
        }
    }
}
