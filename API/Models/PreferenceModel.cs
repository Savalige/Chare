using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Preferences")]
    public class PreferenceModel
    {
        [Key]
        public int Pre_Id { get; set; }
        public string Pre_Text { get; set; } = string.Empty;
        public string Pre_InfoText { get; set; } = string.Empty;

        //TODO: Is this correct? Emoji
        [Column(TypeName = "utf8mb4")]
        public char Pre_Emoji { get; set; }

        public virtual ICollection<TripPreferenceModel>? Pre_TripPreferenceModel { get; set; }
    }
}
