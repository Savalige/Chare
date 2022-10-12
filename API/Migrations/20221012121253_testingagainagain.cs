using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace API.Migrations
{
    public partial class testingagainagain : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Tbl_ProfileInterests");

            migrationBuilder.AddColumn<int>(
                name: "ProfileModelPr_Id",
                table: "Tbl_Interests",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Interests_ProfileModelPr_Id",
                table: "Tbl_Interests",
                column: "ProfileModelPr_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Interests_Tbl_Profiles_ProfileModelPr_Id",
                table: "Tbl_Interests",
                column: "ProfileModelPr_Id",
                principalTable: "Tbl_Profiles",
                principalColumn: "Pr_Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Interests_Tbl_Profiles_ProfileModelPr_Id",
                table: "Tbl_Interests");

            migrationBuilder.DropIndex(
                name: "IX_Tbl_Interests_ProfileModelPr_Id",
                table: "Tbl_Interests");

            migrationBuilder.DropColumn(
                name: "ProfileModelPr_Id",
                table: "Tbl_Interests");

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

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ProfileInterests_In_Id",
                table: "Tbl_ProfileInterests",
                column: "In_Id");
        }
    }
}
