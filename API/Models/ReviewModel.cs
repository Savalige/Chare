using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Reviews")]
    public class ReviewModel
    {
        [Key]
        public int Re_Id { get; set; }

        [Column(TypeName = "Date")]
        public DateTime Re_DateTime { get; set; }
        public int Re_Rating { get; set; }
        public string Re_Text { get; set; } = String.Empty;

        public ProfileModel Re_Rater { get; set; }
        public int Re_Rater_Id { get; set; }
        public ProfileModel Re_Rated { get; set; }
        public int Re_Rated_Id { get; set; }
    }
}
