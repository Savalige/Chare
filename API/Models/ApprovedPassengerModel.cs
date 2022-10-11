using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_ApprovedPassengers")]
    public class ApprovedPassengerModel
    {
        [Key]
        public int AP_Id { get; set; }
        public string AP_Start { get; set; } = String.Empty;
        public string AP_Destination { get; set; } = String.Empty;  
        public int AP_Price { get; set; }
        public ProfileModel AP_Passenger { get; set; }
    }
}
