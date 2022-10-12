using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace API.Migrations
{
    public partial class fixedloops : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_ApprovedPassengers_Tbl_Trips_AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Requests_Tbl_Trips_Rq_TripTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Trips_Tbl_Cars_Tr_CarCa_Id",
                table: "Tbl_Trips");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Trips_Tbl_Profiles_Tr_DriverPr_Id",
                table: "Tbl_Trips");

            migrationBuilder.DropIndex(
                name: "IX_Tbl_Requests_Rq_TripTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropIndex(
                name: "IX_Tbl_ApprovedPassengers_AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.DropColumn(
                name: "Rq_TripTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropColumn(
                name: "AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.AlterColumn<int>(
                name: "Tr_DriverPr_Id",
                table: "Tbl_Trips",
                type: "int",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AlterColumn<int>(
                name: "Tr_CarCa_Id",
                table: "Tbl_Trips",
                type: "int",
                nullable: true,
                oldClrType: typeof(int),
                oldType: "int");

            migrationBuilder.AddColumn<int>(
                name: "TripModelTr_Id",
                table: "Tbl_Requests",
                type: "int",
                nullable: true);

            migrationBuilder.AddColumn<int>(
                name: "TripModelTr_Id",
                table: "Tbl_ApprovedPassengers",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Requests_TripModelTr_Id",
                table: "Tbl_Requests",
                column: "TripModelTr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ApprovedPassengers_TripModelTr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "TripModelTr_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_ApprovedPassengers_Tbl_Trips_TripModelTr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "TripModelTr_Id",
                principalTable: "Tbl_Trips",
                principalColumn: "Tr_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Requests_Tbl_Trips_TripModelTr_Id",
                table: "Tbl_Requests",
                column: "TripModelTr_Id",
                principalTable: "Tbl_Trips",
                principalColumn: "Tr_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Trips_Tbl_Cars_Tr_CarCa_Id",
                table: "Tbl_Trips",
                column: "Tr_CarCa_Id",
                principalTable: "Tbl_Cars",
                principalColumn: "Ca_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Trips_Tbl_Profiles_Tr_DriverPr_Id",
                table: "Tbl_Trips",
                column: "Tr_DriverPr_Id",
                principalTable: "Tbl_Profiles",
                principalColumn: "Pr_Id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_ApprovedPassengers_Tbl_Trips_TripModelTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Requests_Tbl_Trips_TripModelTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Trips_Tbl_Cars_Tr_CarCa_Id",
                table: "Tbl_Trips");

            migrationBuilder.DropForeignKey(
                name: "FK_Tbl_Trips_Tbl_Profiles_Tr_DriverPr_Id",
                table: "Tbl_Trips");

            migrationBuilder.DropIndex(
                name: "IX_Tbl_Requests_TripModelTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropIndex(
                name: "IX_Tbl_ApprovedPassengers_TripModelTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.DropColumn(
                name: "TripModelTr_Id",
                table: "Tbl_Requests");

            migrationBuilder.DropColumn(
                name: "TripModelTr_Id",
                table: "Tbl_ApprovedPassengers");

            migrationBuilder.AlterColumn<int>(
                name: "Tr_DriverPr_Id",
                table: "Tbl_Trips",
                type: "int",
                nullable: false,
                defaultValue: 0,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AlterColumn<int>(
                name: "Tr_CarCa_Id",
                table: "Tbl_Trips",
                type: "int",
                nullable: false,
                defaultValue: 0,
                oldClrType: typeof(int),
                oldType: "int",
                oldNullable: true);

            migrationBuilder.AddColumn<int>(
                name: "Rq_TripTr_Id",
                table: "Tbl_Requests",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.AddColumn<int>(
                name: "AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Requests_Rq_TripTr_Id",
                table: "Tbl_Requests",
                column: "Rq_TripTr_Id");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_ApprovedPassengers_AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "AP_TripTr_Id");

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_ApprovedPassengers_Tbl_Trips_AP_TripTr_Id",
                table: "Tbl_ApprovedPassengers",
                column: "AP_TripTr_Id",
                principalTable: "Tbl_Trips",
                principalColumn: "Tr_Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Requests_Tbl_Trips_Rq_TripTr_Id",
                table: "Tbl_Requests",
                column: "Rq_TripTr_Id",
                principalTable: "Tbl_Trips",
                principalColumn: "Tr_Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Trips_Tbl_Cars_Tr_CarCa_Id",
                table: "Tbl_Trips",
                column: "Tr_CarCa_Id",
                principalTable: "Tbl_Cars",
                principalColumn: "Ca_Id",
                onDelete: ReferentialAction.Cascade);

            migrationBuilder.AddForeignKey(
                name: "FK_Tbl_Trips_Tbl_Profiles_Tr_DriverPr_Id",
                table: "Tbl_Trips",
                column: "Tr_DriverPr_Id",
                principalTable: "Tbl_Profiles",
                principalColumn: "Pr_Id",
                onDelete: ReferentialAction.Cascade);
        }
    }
}
