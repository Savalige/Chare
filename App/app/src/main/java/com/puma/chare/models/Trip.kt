package com.puma.chare.models

import java.util.*

data class Trip (var Tr_Id: Int?, var Tr_Date: String,
                 var Tr_AvaliableSeats: Int, var Tr_Price: Double, var Tr_Destinations: String
                 ,var Tr_Driver: Profile, var Tr_ApprovedPassengers: MutableList<ApprovedPassenger>?
                 ,var Tr_Requests: MutableList<Request>
                 ,var Tr_DeclinedProfiles: MutableList<Profile>
                 ,var Tr_TripPreferences: MutableList<Preference>){
    constructor() : this(null,"",0,0.0,"",
        Profile(),null,mutableListOf<Request>(),mutableListOf<Profile>(),
        mutableListOf<Preference>())
}