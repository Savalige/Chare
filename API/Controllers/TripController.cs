using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API.Data;
using API.Models;
using Newtonsoft.Json;

/*
    TODO: Fix post and put depending on how the data is sent, and filtering depending on price.  
 */

namespace API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TripController : ControllerBase
    {
        private readonly Database _context;

        public TripController(Database context)
        {
            _context = context;
        }

        // GET: api/Trip
        [HttpGet]
        public async Task<ActionResult<IEnumerable<TripModel>>> GetTrips()
        {
            return await _context.Trips.ToListAsync();
        }

        // GET: api/Trip/Search
        //TODO: Fix filtering after price (min and max, depending on gas-prices and also distance)
        [HttpGet("Search/{start, end, time, preferences?}")]
        public async Task<ActionResult<IEnumerable<TripModel>>> GetTripsSearch([FromQuery] string start, string end, DateTime time, string preferences)
        { 
            if (preferences is not null)
            {
                // Make preferences into a list of int
                var preferenceList = preferences.Split(',').Select(int.Parse).ToList();
                return await _context.Trips
                .Where(t => 
                    t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(start) > -1
                    && t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(end) > -1
                    && t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(start) 
                    < t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(end)
                    )
                .Where(t => t.Tr_DateTime > time)
                .Where(t => (t.Tr_TripPreferenceModel.Any(p => preferenceList.Contains(p.Pre_Id))))
                .OrderBy(t => t.Tr_DateTime)
                .ToListAsync();
            }
            else
            {
                return await _context.Trips
                .Where(t =>
                    t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(start) > -1
                    && t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(end) > -1
                    && t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(start)
                    < t.Tr_Destinations.Split(':', System.StringSplitOptions.None).ToList().IndexOf(end)
                    )
                .Where(t => t.Tr_DateTime > time)
                .OrderBy(t => t.Tr_DateTime)
                .ToListAsync();
            }
        }
        // GET: api/Trip/Driver/{profileID}
        // Get a profiles owned trips, 5 hours back in time. 
        [HttpGet("Driver/{profileID}")]
        public async Task<ActionResult<IEnumerable<TripModel>>> GetOwnedTrips(int profileID)
        {
            return await _context.Trips
            .Where(t => (t.Tr_Driver.Pr_Id == profileID && t.Tr_DateTime > (DateTime.Now.AddHours(-5))))
            .OrderBy(t => t.Tr_DateTime)
            .ToListAsync();
        }

        // GET: api/Trip/Passenger/{profileID}
        // Get a profiles passenger-trips, 5 hours back in time. 
        [HttpGet("Passenger/{profileID}")]
        public async Task<ActionResult<IEnumerable<TripModel>>> GetPassengerTrips(int profileID)
        {
            return await _context.Trips
            .Where(t => (
                t.Tr_ApprovedPassengers.Any(a => a.AP_Passenger.Pr_Id == profileID) 
                || t.Tr_Requests.Any(r => r.Rq_Profile.Pr_Id == profileID) 
                && t.Tr_DateTime > (DateTime.Now.AddHours(-5)))
                )
            .OrderBy(t => t.Tr_DateTime)
            .ToListAsync();
        }

        // GET: api/Trip/OldTrips/{profileID}
        // Get a profiles old trips, from 5 hours back in time. 
        [HttpGet("OldTrips/{profileID}")]
        public async Task<ActionResult<IEnumerable<TripModel>>> GetOldTrips(int profileID)
        {
            return await _context.Trips
            .Where(t => (
                t.Tr_Driver.Pr_Id == profileID
                || t.Tr_ApprovedPassengers.Any(a => a.AP_Passenger.Pr_Id == profileID)
                || t.Tr_Requests.Any(r => r.Rq_Profile.Pr_Id == profileID)
                && t.Tr_DateTime > (DateTime.Now.AddHours(+5)))
                )
            .OrderBy(t => t.Tr_DateTime)
            .ToListAsync();
        }

        // GET: api/Trip/5
        [HttpGet("{id}")]
        public async Task<ActionResult<TripModel>> GetTrip(int id)
        {
            var tripModel = await _context.Trips
                .Where(t => t.Tr_Id == id)
                .Include(t => t.Tr_Car)
                .Include(t => t.Tr_Driver)
                .Include(t => t.Tr_ApprovedPassengers)
                .Include(t => t.Tr_DeclinedModel)
                .Include(t => t.Tr_Requests)
                .Include(t => t.Tr_TripPreferenceModel)
                .FirstOrDefaultAsync();

            if (tripModel == null)
            {
                return NotFound();
            }

            return tripModel;
        }

        // POST: api/Trip
        [HttpPost]
        public async Task<ActionResult<TripModel>> PostTripModel([FromForm] string tripdata)
        {
           
            dynamic m = JsonConvert.DeserializeObject(tripdata);

            TripModel tripModel = new TripModel();

            tripModel.Tr_DateTime = m.tr_DateTime;
            tripModel.Tr_AvaliableSeats = m.tr_AvaliableSeats;
            tripModel.Tr_Price = m.tr_Price;
            tripModel.Tr_Destinations = m.tr_Destinations;
            tripModel.Tr_Car = await _context.Cars.FindAsync(Convert.ToInt32(m.tr_Car.ca_Id));
            tripModel.Tr_Driver = await _context.Profiles.FindAsync(Convert.ToInt32(m.tr_Driver.pr_Id));

            _context.Trips.Add(tripModel);
            await _context.SaveChangesAsync();
            return CreatedAtAction("GetTrip", new { id = tripModel.Tr_Id }, tripModel);
        }

        // PUT: api/Trip/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutTripModel(int id, TripModel tripModel)
        {
            if (id != tripModel.Tr_Id)
            {
                return BadRequest();
            }

            _context.Entry(tripModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!TripModelExists(id))
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

        // DELETE: api/Trip/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteTripModel(int id)
        {
            var tripModel = await _context.Trips.FindAsync(id);
            if (tripModel == null)
            {
                return NotFound();
            }

            _context.Trips.Remove(tripModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool TripModelExists(int id)
        {
            return _context.Trips.Any(e => e.Tr_Id == id);
        }
    }
}
