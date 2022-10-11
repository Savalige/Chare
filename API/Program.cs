using API.Data;
using Microsoft.EntityFrameworkCore;

//var MyAllowSpecificOrigins = "_myAllowSpecificOrigins";

var builder = WebApplication.CreateBuilder(args);

/*builder.Services.AddCors(options =>
{
	options.AddPolicy(name: MyAllowSpecificOrigins,
					  policy =>
					  {
						  policy.WithOrigins("https://localhost:44413",
											  "https://localhost:7256",
											  "https://localhost:5256")
											  .AllowAnyHeader()
											  .AllowAnyMethod();
					  });
});*/

// Add services to the container.

builder.Services.AddControllers();
builder.Services.AddDbContext<Database>(options =>
    options.UseMySql(connectionString: @Config.ConnectionString,
            new MySqlServerVersion(new Version(8, 0, 27))));

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

// Disabling https
//app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
