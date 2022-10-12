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
    public class CarController : ControllerBase
    {
        private readonly Database _context;

        public CarController(Database context)
        {
            _context = context;
        }

        // GET: api/Car
        [HttpGet]
        public async Task<ActionResult<IEnumerable<CarModel>>> GetCars()
        {
            return await _context.Cars.ToListAsync();
        }

        // GET: api/Car/5
        [HttpGet("{id}")]
        public async Task<ActionResult<CarModel>> GetCarModel(int id)
        {
            var carModel = await _context.Cars.Where(c => c.Ca_Id == id)
                .Include(c => c.Ca_Owner)
                .FirstAsync();

            if (carModel == null)
            {
                return NotFound();
            }

            return carModel;
        }

        // GET: api/Car/Profile/5
        [HttpGet("Profile/{id}")]
        public async Task<ActionResult<IEnumerable<CarModel>>> GetCarProfile(int id)
        {
            var carModel = await _context.Cars.Where(c => c.Ca_Owner.Pr_Id == id)
                .Include(c => c.Ca_Owner)
                .ToListAsync();

            if (carModel == null)
            {
                return NotFound();
            }

            return carModel;
        }

        // PUT: api/Car/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutCarModel(int id, CarModel carModel)
        {
            if (id != carModel.Ca_Id)
            {
                return BadRequest();
            }

            _context.Entry(carModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CarModelExists(id))
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

        // POST: api/Car
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<CarModel>> PostCarModel([FromForm] string cardata)
        {

            dynamic m = JsonConvert.DeserializeObject(cardata);

            CarModel carModel = new CarModel();

            carModel.Ca_Model = m.ca_Model;
            carModel.Ca_Owner = await _context.Profiles.FindAsync(Convert.ToInt32(m.ca_Owner.pr_Id));
            carModel.Ca_Seats = m.ca_Seats;
            carModel.Ca_Color = m.ca_Color;
            carModel.Ca_Fuel = m.ca_Fuel;
            carModel.Ca_FuelCon = m.ca_FuelCon;
            _context.Cars.Add(carModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetCarModel", new { id = carModel.Ca_Id }, carModel);
        }


        // DELETE: api/Car/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteCarModel(int id)
        {
            var carModel = await _context.Cars.FindAsync(id);
            if (carModel == null)
            {
                return NotFound();
            }

            _context.Cars.Remove(carModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool CarModelExists(int id)
        {
            return _context.Cars.Any(e => e.Ca_Id == id);
        }
    }
}
