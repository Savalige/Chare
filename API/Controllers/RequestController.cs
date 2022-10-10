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
            var requestModel = await _context.Requests.FindAsync(id);

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
        public async Task<ActionResult<RequestModel>> PostRequestModel(RequestModel requestModel)
        {
            _context.Requests.Add(requestModel);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRequestModel", new { id = requestModel.Rq_Id }, requestModel);
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
