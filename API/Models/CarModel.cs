using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Cars")]
    public class CarModel
    {
        [Key]
        public int Ca_Id { get; set; }
        public string Ca_Model { get; set; } = String.Empty;
        public string Ca_Color { get; set; } = String.Empty;
        public int Ca_Seats { get; set; }
        public double Ca_FuelCon { get; set; }
        public string Ca_Fuel { get; set; } = String.Empty;

        public ProfileModel Ca_Owner { get; set; }
    }
}
