using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Interests")]
    public class InterestModel
    {
        [Key]
        public int In_Id { get; set; }

        //TODO: Is this correct? Emoji
        [Column(TypeName = "utf8mb4")]
        public char In_Emoji { get; set; }
        public string In_Text { get; set; } = String.Empty;

        public virtual ICollection<ProfileInterestModel>? In_ProfileInterestModel { get; set; }
    }
}