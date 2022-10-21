package com.puma.chare.models

data class Car(var ca_Id: Int?, var ca_Model: String, var ca_Color: String,
               var ca_Seats: Int, var ca_FuelCon: Double, var ca_Fuel: String,
               var ca_Owner: Profile?, var ca_Trips: MutableList<Trip>?) {
    constructor() : this(null,"","",0,0.0,
        "",null,null)
}