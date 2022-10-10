using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using Microsoft.EntityFrameworkCore;

namespace API.Models
{
    [Table("Tbl_ProfileInterests")]
    [Keyless]
    public class ProfileInterestModel
    {
        public ProfileModel Pr_In_Profile { get; set; }
        public InterestModel Pr_In_Interest { get; set; }
        public int Pr_Id { get; set; }
        public int In_Id { get; set; }
    }
}
