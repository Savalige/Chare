using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace API.Migrations
{
    public partial class testingagain2 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Requests_Tbl_Profiles_Rq_ProfilePr_Id",
                table: "Tbl_Requests");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Requests_Tbl_Profiles_Rq_ProfilePr_Id",
                table: "Tbl_Requests",
                column: "Rq_ProfilePr_Id",
                principalTable: "Tbl_Profiles",
                principalColumn: "Pr_Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Requests_Tbl_Profiles_Rq_ProfilePr_Id",
                table: "Tbl_Requests");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Requests_Tbl_Profiles_Rq_ProfilePr_Id",
                table: "Tbl_Requests",
                column: "Rq_ProfilePr_Id",
                principalTable: "Tbl_Profiles",
                principalColumn: "Pr_Id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
