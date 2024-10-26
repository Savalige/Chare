﻿using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace API.Models
{
    [Table("Tbl_Profiles")]
    public class ProfileModel
    {
        [Key]
        public int Pr_Id { get; set; }
        public string Pr_Firstname { get; set; } = String.Empty;
        public string Pr_Lastname { get; set; } = String.Empty;
        [Column(TypeName = "Date")]
        public DateTime Pr_BirthDate { get; set; }
        public string Pr_Img { get; set; } = String.Empty;
        public int Pr_DriveDistance { get; set; }
        public int Pr_DriveNum { get; set; }
        public int Pr_RideDistance { get; set; }
        public int Pr_RideNum { get; set; }
        public string Pr_Email { get; set; } = String.Empty;
        public string Pr_Password { get; set; } = String.Empty;
        public string Pr_Bio { get; set; } = String.Empty;

        public virtual ICollection<DeclinedModel>? Pr_DeclinedModel { get; set; }
        //public virtual ICollection<ProfileInterestModel>? Pr_ProfileInterestModel { get; set; }
        //TODO: Doublecheck that the db know which is which of rater and rated.
        // Maybe have to change here? 
        public virtual ICollection<InterestModel>? Pr_ProfileInterests { get; set; }
        public virtual ICollection<ReviewModel>? Pr_Rater { get; set; }
        public virtual ICollection<ReviewModel>? Pr_Rated { get; set; }


    }
}
