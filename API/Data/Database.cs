using API.Models;
using Microsoft.EntityFrameworkCore;

namespace API.Data
{
    public class Database : DbContext
    {
        public Database(DbContextOptions<Database> options) : base(options) {}

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // PROFILE INTERESTS
            /*
            modelBuilder.Entity<ProfileInterestModel>()
            .HasKey(p => new { p.Pr_Id, p.In_Id });

            modelBuilder.Entity<ProfileInterestModel>()
                .HasOne(p => p.Pr_In_Interest)
                .WithMany(p => p.In_ProfileInterestModel)
                .HasForeignKey(p => p.In_Id);

            modelBuilder.Entity<ProfileInterestModel>()
                .HasOne(p => p.Pr_In_Profile)
                .WithMany(c => c.Pr_ProfileInterestModel)
                .HasForeignKey(p => p.Pr_Id);*/

            //DECLINED requests 
            modelBuilder.Entity<DeclinedModel>()
                .HasKey(p => new { p.Pr_Id, p.Tr_Id});

            modelBuilder.Entity<DeclinedModel>()
                .HasOne(p => p.Dec_Profile)
                .WithMany(p => p.Pr_DeclinedModel)
                .HasForeignKey(p => p.Pr_Id);

            modelBuilder.Entity<DeclinedModel>()
                .HasOne(p => p.Dec_Trip)
                .WithMany(c => c.Tr_DeclinedModel)
                .HasForeignKey(p => p.Tr_Id);

            //TRIPPREFERENCES
            modelBuilder.Entity<TripPreferenceModel>()
                .HasKey(p => new { p.Pre_Id, p.Tr_Id });

            modelBuilder.Entity<TripPreferenceModel>()
                .HasOne(p => p.Tr_Pre_Trip)
                .WithMany(p => p.Tr_TripPreferenceModel)
                .HasForeignKey(p => p.Tr_Id);

            modelBuilder.Entity<TripPreferenceModel>()
                .HasOne(p => p.Tr_Pre_Preference)
                .WithMany(c => c.Pre_TripPreferenceModel)
                .HasForeignKey(p => p.Pre_Id);

            //Reviews
            modelBuilder.Entity<ReviewModel>()
                .HasKey(p => new { p.Re_Rater_Id, p.Re_Rated_Id });

            modelBuilder.Entity<ReviewModel>()
                .HasOne(p => p.Re_Rater)
                .WithMany(p => p.Pr_Rater)
                .HasForeignKey(p => p.Re_Rater_Id);

            modelBuilder.Entity<ReviewModel>()
                .HasOne(p => p.Re_Rated)
                .WithMany(c => c.Pr_Rated)
                .HasForeignKey(p => p.Re_Rated_Id);
        }

        public DbSet<ApprovedPassengerModel> ApprovedPassengers { get; set; }
        public DbSet<CarModel> Cars{ get; set; }
        public DbSet<DeclinedModel> DeclinedRequests { get; set; }
        public DbSet<InterestModel> Interests { get; set; }
        public DbSet<PreferenceModel> Preferences { get; set; }
       // public DbSet<ProfileInterestModel> ProfileInterests { get; set; }
        public DbSet<ProfileModel> Profiles { get; set; }
        public DbSet<RequestModel> Requests { get; set; }
        public DbSet<ReviewModel> Reviews { get; set; }
        public DbSet<TripModel> Trips { get; set; }
        public DbSet<TripPreferenceModel> TripPreferences { get; set; }

    }
}
