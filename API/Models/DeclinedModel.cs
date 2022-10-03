using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    [Table("Tbl_Declined")]
    [Keyless]
    public class DeclinedModel
    {
        public TripModel Dec_Trip { get; set; }
        public ProfileModel Dec_Profile { get; set; }
        public int Tr_Id { get; set; }
        public int Pr_Id { get; set; }
    }
}
