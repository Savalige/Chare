﻿// <auto-generated />
using System;
using API.Data;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;

#nullable disable

namespace API.Migrations
{
    [DbContext(typeof(Database))]
    [Migration("20221003133054_InitialCreate")]
    partial class InitialCreate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("ProductVersion", "6.0.9")
                .HasAnnotation("Relational:MaxIdentifierLength", 64);

            modelBuilder.Entity("API.Models.ApprovedPassengerModel", b =>
                {
                    b.Property<int>("AP_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("AP_Destination")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("AP_PassengerPr_Id")
                        .HasColumnType("int");

                    b.Property<int>("AP_Price")
                        .HasColumnType("int");

                    b.Property<string>("AP_Start")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("AP_TripTr_Id")
                        .HasColumnType("int");

                    b.HasKey("AP_Id");

                    b.HasIndex("AP_PassengerPr_Id");

                    b.HasIndex("AP_TripTr_Id");

                    b.ToTable("Tbl_ApprovedPassengers");
                });

            modelBuilder.Entity("API.Models.CarModel", b =>
                {
                    b.Property<int>("Ca_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("Ca_Color")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<double>("Ca_FuelCon")
                        .HasColumnType("double");

                    b.Property<string>("Ca_Model")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("Ca_OwnerPr_Id")
                        .HasColumnType("int");

                    b.Property<int>("Ca_Seats")
                        .HasColumnType("int");

                    b.HasKey("Ca_Id");

                    b.HasIndex("Ca_OwnerPr_Id");

                    b.ToTable("Tbl_Cars");
                });

            modelBuilder.Entity("API.Models.DeclinedModel", b =>
                {
                    b.Property<int>("Pr_Id")
                        .HasColumnType("int");

                    b.Property<int>("Tr_Id")
                        .HasColumnType("int");

                    b.HasKey("Pr_Id", "Tr_Id");

                    b.HasIndex("Tr_Id");

                    b.ToTable("Tbl_Declined");
                });

            modelBuilder.Entity("API.Models.InterestModel", b =>
                {
                    b.Property<int>("In_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("In_Emoji")
                        .IsRequired()
                        .HasColumnType("varchar(1)");

                    b.Property<string>("In_Text")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.HasKey("In_Id");

                    b.ToTable("Tbl_Interests");
                });

            modelBuilder.Entity("API.Models.PreferenceModel", b =>
                {
                    b.Property<int>("Pre_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("Pre_Emoji")
                        .IsRequired()
                        .HasColumnType("varchar(1)");

                    b.Property<string>("Pre_InfoText")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Pre_Text")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.HasKey("Pre_Id");

                    b.ToTable("Tbl_Preferences");
                });

            modelBuilder.Entity("API.Models.ProfileInterestModel", b =>
                {
                    b.Property<int>("Pr_Id")
                        .HasColumnType("int");

                    b.Property<int>("In_Id")
                        .HasColumnType("int");

                    b.HasKey("Pr_Id", "In_Id");

                    b.HasIndex("In_Id");

                    b.ToTable("Tbl_ProfileInterests");
                });

            modelBuilder.Entity("API.Models.ProfileModel", b =>
                {
                    b.Property<int>("Pr_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("Pr_Bio")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<DateTime>("Pr_BirthDate")
                        .HasColumnType("Date");

                    b.Property<int>("Pr_DriveDistance")
                        .HasColumnType("int");

                    b.Property<int>("Pr_DriveNum")
                        .HasColumnType("int");

                    b.Property<string>("Pr_Email")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Pr_Firstname")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Pr_Img")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Pr_Lastname")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Pr_Password")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("Pr_RideDistance")
                        .HasColumnType("int");

                    b.Property<int>("Pr_RideNum")
                        .HasColumnType("int");

                    b.HasKey("Pr_Id");

                    b.ToTable("Tbl_Profiles");
                });

            modelBuilder.Entity("API.Models.RequestModel", b =>
                {
                    b.Property<int>("Rq_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<string>("Rq_Destination")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<string>("Rq_Message")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("Rq_Price")
                        .HasColumnType("int");

                    b.Property<int>("Rq_ProfilePr_Id")
                        .HasColumnType("int");

                    b.Property<string>("Rq_Start")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("Rq_TripTr_Id")
                        .HasColumnType("int");

                    b.HasKey("Rq_Id");

                    b.HasIndex("Rq_ProfilePr_Id");

                    b.HasIndex("Rq_TripTr_Id");

                    b.ToTable("Tbl_Requests");
                });

            modelBuilder.Entity("API.Models.ReviewModel", b =>
                {
                    b.Property<int>("Re_Rater_Id")
                        .HasColumnType("int");

                    b.Property<int>("Re_Rated_Id")
                        .HasColumnType("int");

                    b.Property<DateTime>("Re_DateTime")
                        .HasColumnType("Date");

                    b.Property<int>("Re_Id")
                        .HasColumnType("int");

                    b.Property<int>("Re_Rating")
                        .HasColumnType("int");

                    b.Property<string>("Re_Text")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.HasKey("Re_Rater_Id", "Re_Rated_Id");

                    b.HasIndex("Re_Rated_Id");

                    b.ToTable("Tbl_Reviews");
                });

            modelBuilder.Entity("API.Models.TripModel", b =>
                {
                    b.Property<int>("Tr_Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int");

                    b.Property<int>("Tr_AvaliableSeats")
                        .HasColumnType("int");

                    b.Property<int>("Tr_CarCa_Id")
                        .HasColumnType("int");

                    b.Property<DateTime>("Tr_DateTime")
                        .HasColumnType("Date");

                    b.Property<string>("Tr_Destinations")
                        .IsRequired()
                        .HasColumnType("longtext");

                    b.Property<int>("Tr_DriverPr_Id")
                        .HasColumnType("int");

                    b.Property<int>("Tr_Price")
                        .HasColumnType("int");

                    b.HasKey("Tr_Id");

                    b.HasIndex("Tr_CarCa_Id");

                    b.HasIndex("Tr_DriverPr_Id");

                    b.ToTable("Tbl_Trips");
                });

            modelBuilder.Entity("API.Models.TripPreferenceModel", b =>
                {
                    b.Property<int>("Pre_Id")
                        .HasColumnType("int");

                    b.Property<int>("Tr_Id")
                        .HasColumnType("int");

                    b.HasKey("Pre_Id", "Tr_Id");

                    b.HasIndex("Tr_Id");

                    b.ToTable("Tbl_TripPreferences");
                });

            modelBuilder.Entity("API.Models.ApprovedPassengerModel", b =>
                {
                    b.HasOne("API.Models.ProfileModel", "AP_Passenger")
                        .WithMany("Pr_ApprovedPassengerModel")
                        .HasForeignKey("AP_PassengerPr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.TripModel", "AP_Trip")
                        .WithMany("Tr_ApprovedPassengers")
                        .HasForeignKey("AP_TripTr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("AP_Passenger");

                    b.Navigation("AP_Trip");
                });

            modelBuilder.Entity("API.Models.CarModel", b =>
                {
                    b.HasOne("API.Models.ProfileModel", "Ca_Owner")
                        .WithMany("Pr_Cars")
                        .HasForeignKey("Ca_OwnerPr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Ca_Owner");
                });

            modelBuilder.Entity("API.Models.DeclinedModel", b =>
                {
                    b.HasOne("API.Models.ProfileModel", "Dec_Profile")
                        .WithMany("Pr_DeclinedModel")
                        .HasForeignKey("Pr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.TripModel", "Dec_Trip")
                        .WithMany("Tr_DeclinedModel")
                        .HasForeignKey("Tr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Dec_Profile");

                    b.Navigation("Dec_Trip");
                });

            modelBuilder.Entity("API.Models.ProfileInterestModel", b =>
                {
                    b.HasOne("API.Models.InterestModel", "Pr_In_Interest")
                        .WithMany("In_ProfileInterestModel")
                        .HasForeignKey("In_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.ProfileModel", "Pr_In_Profile")
                        .WithMany("Pr_ProfileInterestModel")
                        .HasForeignKey("Pr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Pr_In_Interest");

                    b.Navigation("Pr_In_Profile");
                });

            modelBuilder.Entity("API.Models.RequestModel", b =>
                {
                    b.HasOne("API.Models.ProfileModel", "Rq_Profile")
                        .WithMany("Pr_RequestModel")
                        .HasForeignKey("Rq_ProfilePr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.TripModel", "Rq_Trip")
                        .WithMany("Tr_Requests")
                        .HasForeignKey("Rq_TripTr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Rq_Profile");

                    b.Navigation("Rq_Trip");
                });

            modelBuilder.Entity("API.Models.ReviewModel", b =>
                {
                    b.HasOne("API.Models.ProfileModel", "Re_Rated")
                        .WithMany("Pr_Rated")
                        .HasForeignKey("Re_Rated_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.ProfileModel", "Re_Rater")
                        .WithMany("Pr_Rater")
                        .HasForeignKey("Re_Rater_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Re_Rated");

                    b.Navigation("Re_Rater");
                });

            modelBuilder.Entity("API.Models.TripModel", b =>
                {
                    b.HasOne("API.Models.CarModel", "Tr_Car")
                        .WithMany("Ca_Trips")
                        .HasForeignKey("Tr_CarCa_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.ProfileModel", "Tr_Driver")
                        .WithMany("Pr_Driver")
                        .HasForeignKey("Tr_DriverPr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Tr_Car");

                    b.Navigation("Tr_Driver");
                });

            modelBuilder.Entity("API.Models.TripPreferenceModel", b =>
                {
                    b.HasOne("API.Models.PreferenceModel", "Tr_Pre_Preference")
                        .WithMany("Pre_TripPreferenceModel")
                        .HasForeignKey("Pre_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.HasOne("API.Models.TripModel", "Tr_Pre_Trip")
                        .WithMany("Tr_TripPreferenceModel")
                        .HasForeignKey("Tr_Id")
                        .OnDelete(DeleteBehavior.Cascade)
                        .IsRequired();

                    b.Navigation("Tr_Pre_Preference");

                    b.Navigation("Tr_Pre_Trip");
                });

            modelBuilder.Entity("API.Models.CarModel", b =>
                {
                    b.Navigation("Ca_Trips");
                });

            modelBuilder.Entity("API.Models.InterestModel", b =>
                {
                    b.Navigation("In_ProfileInterestModel");
                });

            modelBuilder.Entity("API.Models.PreferenceModel", b =>
                {
                    b.Navigation("Pre_TripPreferenceModel");
                });

            modelBuilder.Entity("API.Models.ProfileModel", b =>
                {
                    b.Navigation("Pr_ApprovedPassengerModel");

                    b.Navigation("Pr_Cars");

                    b.Navigation("Pr_DeclinedModel");

                    b.Navigation("Pr_Driver");

                    b.Navigation("Pr_ProfileInterestModel");

                    b.Navigation("Pr_Rated");

                    b.Navigation("Pr_Rater");

                    b.Navigation("Pr_RequestModel");
                });

            modelBuilder.Entity("API.Models.TripModel", b =>
                {
                    b.Navigation("Tr_ApprovedPassengers");

                    b.Navigation("Tr_DeclinedModel");

                    b.Navigation("Tr_Requests");

                    b.Navigation("Tr_TripPreferenceModel");
                });
#pragma warning restore 612, 618
        }
    }
}
