using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    [Table("Tbl_Approved")]
    [Keyless]
    public class ApprovedModel
    {
        public TripModel Apr_Trip { get; set; }
        public ApprovedPassengerModel Apr_ApprovedPassenger { get; set; }
        public int Tr_Id { get; set; }
        public int AP_Id { get; set; }
    }
}
