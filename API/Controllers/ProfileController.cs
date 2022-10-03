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
    public class ProfileController : ControllerBase
    {
        private readonly Database _context;

        public ProfileController(Database context)
        {
            _context = context;
        }

        // GET: api/Profile
        [HttpGet]
        public async Task<ActionResult<IEnumerable<ProfileModel>>> GetProfiles()
        {
            return await _context.Profiles.ToListAsync();
        }

        // GET: api/Profile/5
        [HttpGet("{id}")]
        public async Task<ActionResult<ProfileModel>> GetProfileModel(int id)
        {
            var profileModel = await _context.Profiles.FindAsync(id);

            if (profileModel == null)
            {
                return NotFound();
            }

            return profileModel;
        }

        // PUT: api/Profile/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutProfileModel(int id, ProfileModel profileModel)
        {
            if (id != profileModel.Pr_Id)
            {
                return BadRequest();
            }

            _context.Entry(profileModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ProfileModelExists(id))
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

        // POST: api/Profile
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<ProfileModel>> PostProfileModel(ProfileModel profileModel)
        {
            _context.Profiles.Add(profileModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetProfileModel", new { id = profileModel.Pr_Id }, profileModel);
        }

        // DELETE: api/Profile/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteProfileModel(int id)
        {
            var profileModel = await _context.Profiles.FindAsync(id);
            if (profileModel == null)
            {
                return NotFound();
            }

            _context.Profiles.Remove(profileModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ProfileModelExists(int id)
        {
            return _context.Profiles.Any(e => e.Pr_Id == id);
        }
    }
}
