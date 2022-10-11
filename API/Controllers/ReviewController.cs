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
    public class ReviewController : ControllerBase
    {
        private readonly Database _context;

        public ReviewController(Database context)
        {
            _context = context;
        }

        // GET: api/Review/fromProfile/5
        [HttpGet("fromProfile/{id}")]
        public async Task<ActionResult<IEnumerable<ReviewModel>>> GetAllProfileReviews(int id)
        {
            return await _context.Reviews
                .Where(r => r.Re_Rated_Id == id)
                .Include(r => r.Re_Rater)
                .OrderBy(r => r.Re_DateTime)
                .ToListAsync();
        }

        // GET: api/Review/latest/5
        [HttpGet("latest/{id}")]
        public async Task<ActionResult<ReviewModel>> GetLatestProfileReview(int id)
        {
            return await _context.Reviews.Where(r => r.Re_Rated_Id == id)
                .Include(r => r.Re_Rater)
                .OrderBy(r => r.Re_DateTime)
                .FirstAsync();
        }

        // PUT: api/Review/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutReview(int id, ReviewModel reviewModel)
        {
            if (id != reviewModel.Re_Id)
            {
                return BadRequest();
            }

            _context.Entry(reviewModel).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ReviewModelExists(id))
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

        // POST: api/Review
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<ReviewModel>> PostReview(ReviewModel reviewModel)
        {
            _context.Reviews.Add(reviewModel);
            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (ReviewModelExists(reviewModel.Re_Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtAction("GetReview", new { id = reviewModel.Re_Id }, reviewModel);
        }

        // DELETE: api/Review/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteReview(int id)
        {
            var reviewModel = await _context.Reviews.FindAsync(id);
            if (reviewModel == null)
            {
                return NotFound();
            }

            _context.Reviews.Remove(reviewModel);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool ReviewModelExists(int id)
        {
            return _context.Reviews.Any(e => e.Re_Id == id);
        }
    }
}
