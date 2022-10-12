using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace API.Models
{
    [Table("Tbl_Trips")]
    public class TripModel
    {
        [Key]
        public int Tr_Id { get; set; }
        [Column(TypeName = "Date")]
        public DateTime Tr_DateTime { get; set; }
        public int Tr_AvaliableSeats { get; set; }
        public int Tr_Price { get; set; }
        public string Tr_Destinations { get; set; } = string.Empty;

        public CarModel? Tr_Car { get; set; }
        public ProfileModel? Tr_Driver { get; set; }
        public virtual ICollection<ApprovedPassengerModel>? Tr_ApprovedPassengers { get; set; }
        public virtual ICollection<RequestModel>? Tr_Requests { get; set; }
        public virtual ICollection<DeclinedModel>? Tr_DeclinedModel { get; set; }
        public virtual ICollection<TripPreferenceModel>? Tr_TripPreferenceModel { get; set; }

    }
}
