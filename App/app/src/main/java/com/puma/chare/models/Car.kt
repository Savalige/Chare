package com.puma.chare.models

data class Car(var Ca_Id: Int?, var Ca_Model: String, var Ca_Color: String,
               var Ca_Seats: Int, var Ca_FuelCon: Double, var Ca_Fuel: String,
               var Ca_Owner: Profile?, var Ca_Trips: MutableList<Trip>?) {
    constructor() : this(null,"","",0,0.0,
        "",null,null)
}