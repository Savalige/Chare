using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Requests")]
    public class RequestModel
    {
        [Key]
        public int Rq_Id { get; set; }
        public string Rq_Message { get; set; } = String.Empty;
        public int Rq_Price { get; set; }
        public string Rq_Start { get; set; } = String.Empty;
        public string Rq_Destination { get; set; } = String.Empty;

        public ProfileModel Rq_Profile { get; set; }
        public RequestedModel Rq_Requested { get; set; }
    }
}
