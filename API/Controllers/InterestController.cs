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
    public class InterestController : ControllerBase
    {
        private readonly Database _context;

        public InterestController(Database context)
        {
            _context = context;
        }

        // GET: api/Interest
        [HttpGet]
        public async Task<ActionResult<IEnumerable<InterestModel>>> GetInterests()
        {
            return await _context.Interests.ToListAsync();
        }

        // GET: api/Interest/5
        [HttpGet("{id}")]
        public async Task<ActionResult<InterestModel>> GetInterestModel(int id)
        {
            var interestModel = await _context.Interests.FindAsync(id);

            if (interestModel == null)
            {
                return NotFound();
            }

            return interestModel;
        }

        // PUT: api/Interest/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutInterestModel(int id, InterestModel interestModel)
        {
            if (id != interestModel.In_Id)
            {
                return BadRequest();
            }

            _context.Entry(interestModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!InterestModelExists(id))
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

        // POST: api/Interest
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<InterestModel>> PostInterestModel([FromForm] string interestData)
        {
            dynamic i = JsonConvert.DeserializeObject(interestData);

            InterestModel interestModel = new InterestModel();
            interestModel.In_Text = i.in_Text;
            interestModel.In_Emoji = i.in_Emoji;

            _context.Interests.Add(interestModel);

            ProfileModel profile = await _context.Profiles.FindAsync(Convert.ToInt32(i.in_ProfileID));
            if(profile.Pr_ProfileInterests == null)
            {
                profile.Pr_ProfileInterests = new List<InterestModel>();
            }
            profile.Pr_ProfileInterests.Add(interestModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetInterestModel", new { id = interestModel.In_Id }, interestModel);
        }

        // DELETE: api/Interest/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteInterestModel(int id)
        {
            var interestModel = await _context.Interests.FindAsync(id);
            if (interestModel == null)
            {
                return NotFound();
            }

            _context.Interests.Remove(interestModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool InterestModelExists(int id)
        {
            return _context.Interests.Any(e => e.In_Id == id);
        }
    }
}
