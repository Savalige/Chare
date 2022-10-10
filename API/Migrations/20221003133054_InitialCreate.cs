using System;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace API.Migrations
{
    public partial class InitialCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Interests",
                columns: table => new
                {
                    In_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    In_Emoji = table.Column<string>(type: "varchar(1)", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    In_Text = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Interests", x => x.In_Id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Preferences",
                columns: table => new
                {
                    Pre_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    Pre_Text = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pre_InfoText = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pre_Emoji = table.Column<string>(type: "varchar(1)", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Preferences", x => x.Pre_Id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Profiles",
                columns: table => new
                {
                    Pr_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    Pr_Firstname = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pr_Lastname = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pr_BirthDate = table.Column<DateTime>(type: "Date", nullable: false),
                    Pr_Img = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pr_DriveDistance = table.Column<int>(type: "int", nullable: false),
                    Pr_DriveNum = table.Column<int>(type: "int", nullable: false),
                    Pr_RideDistance = table.Column<int>(type: "int", nullable: false),
                    Pr_RideNum = table.Column<int>(type: "int", nullable: false),
                    Pr_Email = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pr_Password = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Pr_Bio = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Profiles", x => x.Pr_Id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Cars",
                columns: table => new
                {
                    Ca_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    Ca_Model = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Ca_Color = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Ca_Seats = table.Column<int>(type: "int", nullable: false),
                    Ca_FuelCon = table.Column<double>(type: "double", nullable: false),
                    Ca_OwnerPr_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Cars", x => x.Ca_Id);
                    table.ForeignKey(
                        name: "FK_Tbl_Cars_Tbl_Profiles_Ca_OwnerPr_Id",
                        column: x => x.Ca_OwnerPr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_ProfileInterests",
                columns: table => new
                {
                    Pr_Id = table.Column<int>(type: "int", nullable: false),
                    In_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_ProfileInterests", x => new { x.Pr_Id, x.In_Id });
                    table.ForeignKey(
                        name: "FK_Tbl_ProfileInterests_Tbl_Interests_In_Id",
                        column: x => x.In_Id,
                        principalTable: "Tbl_Interests",
                        principalColumn: "In_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_ProfileInterests_Tbl_Profiles_Pr_Id",
                        column: x => x.Pr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Reviews",
                columns: table => new
                {
                    Re_Rater_Id = table.Column<int>(type: "int", nullable: false),
                    Re_Rated_Id = table.Column<int>(type: "int", nullable: false),
                    Re_Id = table.Column<int>(type: "int", nullable: false),
                    Re_DateTime = table.Column<DateTime>(type: "Date", nullable: false),
                    Re_Rating = table.Column<int>(type: "int", nullable: false),
                    Re_Text = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4")
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Reviews", x => new { x.Re_Rater_Id, x.Re_Rated_Id });
                    table.ForeignKey(
                        name: "FK_Tbl_Reviews_Tbl_Profiles_Re_Rated_Id",
                        column: x => x.Re_Rated_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_Reviews_Tbl_Profiles_Re_Rater_Id",
                        column: x => x.Re_Rater_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Trips",
                columns: table => new
                {
                    Tr_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    Tr_DateTime = table.Column<DateTime>(type: "Date", nullable: false),
                    Tr_AvaliableSeats = table.Column<int>(type: "int", nullable: false),
                    Tr_Price = table.Column<int>(type: "int", nullable: false),
                    Tr_Destinations = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Tr_CarCa_Id = table.Column<int>(type: "int", nullable: false),
                    Tr_DriverPr_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Trips", x => x.Tr_Id);
                    table.ForeignKey(
                        name: "FK_Tbl_Trips_Tbl_Cars_Tr_CarCa_Id",
                        column: x => x.Tr_CarCa_Id,
                        principalTable: "Tbl_Cars",
                        principalColumn: "Ca_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_Trips_Tbl_Profiles_Tr_DriverPr_Id",
                        column: x => x.Tr_DriverPr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_ApprovedPassengers",
                columns: table => new
                {
                    AP_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    AP_Start = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    AP_Destination = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    AP_Price = table.Column<int>(type: "int", nullable: false),
                    AP_PassengerPr_Id = table.Column<int>(type: "int", nullable: false),
                    AP_TripTr_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_ApprovedPassengers", x => x.AP_Id);
                    table.ForeignKey(
                        name: "FK_Tbl_ApprovedPassengers_Tbl_Profiles_AP_PassengerPr_Id",
                        column: x => x.AP_PassengerPr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_ApprovedPassengers_Tbl_Trips_AP_TripTr_Id",
                        column: x => x.AP_TripTr_Id,
                        principalTable: "Tbl_Trips",
                        principalColumn: "Tr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Declined",
                columns: table => new
                {
                    Tr_Id = table.Column<int>(type: "int", nullable: false),
                    Pr_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Declined", x => new { x.Pr_Id, x.Tr_Id });
                    table.ForeignKey(
                        name: "FK_Tbl_Declined_Tbl_Profiles_Pr_Id",
                        column: x => x.Pr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_Declined_Tbl_Trips_Tr_Id",
                        column: x => x.Tr_Id,
                        principalTable: "Tbl_Trips",
                        principalColumn: "Tr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_Requests",
                columns: table => new
                {
                    Rq_Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    Rq_Message = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Rq_Price = table.Column<int>(type: "int", nullable: false),
                    Rq_Start = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Rq_Destination = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    Rq_ProfilePr_Id = table.Column<int>(type: "int", nullable: false),
                    Rq_TripTr_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Requests", x => x.Rq_Id);
                    table.ForeignKey(
                        name: "FK_Tbl_Requests_Tbl_Profiles_Rq_ProfilePr_Id",
                        column: x => x.Rq_ProfilePr_Id,
                        principalTable: "Tbl_Profiles",
                        principalColumn: "Pr_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_Requests_Tbl_Trips_Rq_TripTr_Id",
                        column: x => x.Rq_TripTr_Id,
                        principalTable: "Tbl_Trips",
                        principalColumn: "Tr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "Tbl_TripPreferences",
                columns: table => new
                {
                    Tr_Id = table.Column<int>(type: "int", nullable: false),
                    Pre_Id = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_TripPreferences", x => new { x.Pre_Id, x.Tr_Id });
                    table.ForeignKey(
                        name: "FK_Tbl_TripPreferences_Tbl_Preferences_Pre_Id",
                        column: x => x.Pre_Id,
                        principalTable: "Tbl_Preferences",
                        principalColumn: "Pre_Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_TripPreferences_Tbl_Trips_Tr_Id",
                        column: x => x.Tr_Id,
                        principalTable: "Tbl_Trips",
                        principalColumn: "Tr_Id",
                        onDelete: ReferentialAction.Cascade);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ApprovedPassengers_AP_PassengerPr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "AP_PassengerPr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ApprovedPassengers_AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "AP_TripTr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Cars_Ca_OwnerPr_Id",
                table: "Tbl_Cars",
                column: "Ca_OwnerPr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Declined_Tr_Id",
                table: "Tbl_Declined",
                column: "Tr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ProfileInterests_In_Id",
                table: "Tbl_ProfileInterests",
                column: "In_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Requests_Rq_ProfilePr_Id",
                table: "Tbl_Requests",
                column: "Rq_ProfilePr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Requests_Rq_TripTr_Id",
                table: "Tbl_Requests",
                column: "Rq_TripTr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Reviews_Re_Rated_Id",
                table: "Tbl_Reviews",
                column: "Re_Rated_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_TripPreferences_Tr_Id",
                table: "Tbl_TripPreferences",
                column: "Tr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Trips_Tr_CarCa_Id",
                table: "Tbl_Trips",
                column: "Tr_CarCa_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Trips_Tr_DriverPr_Id",
                table: "Tbl_Trips",
                column: "Tr_DriverPr_Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Tbl_ApprovedPassengers");

            migrationBuilder.DropTable(
                name: "Tbl_Declined");

            migrationBuilder.DropTable(
                name: "Tbl_ProfileInterests");

            migrationBuilder.DropTable(
                name: "Tbl_Requests");

            migrationBuilder.DropTable(
                name: "Tbl_Reviews");

            migrationBuilder.DropTable(
                name: "Tbl_TripPreferences");

            migrationBuilder.DropTable(
                name: "Tbl_Interests");

            migrationBuilder.DropTable(
                name: "Tbl_Preferences");

            migrationBuilder.DropTable(
                name: "Tbl_Trips");

            migrationBuilder.DropTable(
                name: "Tbl_Cars");

            migrationBuilder.DropTable(
                name: "Tbl_Profiles");
        }
    }
}
