using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    [Table("Tbl_TripPreferences")]
    [Keyless]
    public class TripPreferenceModel
    {
        public TripModel Tr_Pre_Trip { get; set; }
        public PreferenceModel Tr_Pre_Preference { get; set; }
        public int Tr_Id { get; set; }
        public int Pre_Id { get; set; }
    }
}
