package com.puma.chare.models

import java.util.*

data class Trip (var Tr_Id: Int?, var Tr_Date: Date,
                 var Tr_AvaliableSeats: Int, var Tr_Price: Double, var Tr_Destinations: String
                 ,var Tr_Driver: Profile, var Tr_ApprovedPassengers: MutableList<ApprovedPassenger>?
                 ,var Tr_Requests: MutableList<Request>?
                 ,var Tr_DeclinedProfiles: MutableList<Profile>?
                 ,var Tr_TripPreferences: MutableList<Preference>?){
}