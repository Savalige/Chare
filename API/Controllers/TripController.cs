using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using API.Data;
using API.Models;

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

        // GET: api/Trip/5
        [HttpGet("{id}")]
        public async Task<ActionResult<TripModel>> GetTripModel(int id)
        {
            var tripModel = await _context.Trips.FindAsync(id);

            if (tripModel == null)
            {
                return NotFound();
            }

            return tripModel;
        }

        // PUT: api/Trip/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
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

        // POST: api/Trip
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<TripModel>> PostTripModel(TripModel tripModel)
        {
            _context.Trips.Add(tripModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetTripModel", new { id = tripModel.Tr_Id }, tripModel);
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
