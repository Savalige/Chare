using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    [Table("Tbl_Requested")]
    [Keyless]
    public class RequestedModel
    {
        public TripModel Req_Trip { get; set; }
        public RequestModel Req_Request { get; set; }
        public int Tr_Id { get; set; }
        public int Rq_Id { get; set; }
    }
}
