package com.puma.chare.models

import java.util.*

data class Trip (var tr_Id: Int?, var tr_DateTime: String,
                 var tr_AvaliableSeats: Int, var tr_Price: Double, var tr_Destinations: String, var tr_Car:Car?
                 ,var tr_Driver: Profile?, var tr_ApprovedPassengers: MutableList<ApprovedPassenger>?
                 ,var tr_Requests: MutableList<Request>?
                 ,var tr_DeclinedProfiles: MutableList<Profile>?
                 ,var tr_TripPreferences: MutableList<Preference>?){
    constructor() : this(null,"",0,0.0,"",
        null,null,null,null,null, null)
}