package com.puma.chare.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puma.chare.models.*
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class SearchResultsViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    //fun <T: Any?> MutableLiveData<T>.default(initialValue: T) = apply {setValue(initialValue)}
    //val liveData = MutableLiveData<Trip>().default("Hej")
    //private lateinit var trips : MutableLiveData<List<Trip>>

    private lateinit var trips : List<Trip>

    fun getAllTrips() : List<Trip>{
        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val localdate = LocalDate.parse("2022-10-11T18:46:39.245Z",format)
        val date = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        var driver = Profile(1,"Test","Testsson", "2022-10-11T18:46:39.245Z","2",23,24,25,6,"test@mail.com","123","Hej", null)
        var trip1 =  Trip(1, date,4,0.8, "AÖLKJSNfciöabd",driver,null,null,null, null)
        var trip2 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)
        var trip3 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)
        var trip4 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)
        var trip5 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)
        var trip6 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)

        trips = listOf(trip1,trip2,trip3,trip4,trip5,trip6)
        return trips
    }
    /*fun getAllTrips() : LiveData<List<Trip>>{
        val format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val localdate = LocalDate.parse("2022-10-11T18:46:39.245Z",format)
        val date = Date.from(localdate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        var driver = Profile(1,"Test","Testsson", date,"2",23,24,25,6,"test@mail.com","123","Hej", null)
        var trip1 =  Trip(1, date,4,0.8, "Stockholm",driver,null,null,null, null)
        var trip2 =  Trip(2, date,4,0.8, "Stockholm",driver,null,null,null, null)
        trips.value?.plus(trip1)
        trips.value?.plus(trip2)

        return trips}*/

/*data class Trip (var Tr_Id: Int?, var Tr_Date: Date,
     var Tr_AvaliableSeats: Int, var Tr_Price: Double, var Tr_Destinations: String
     , var Tr_Driver: Profile, var Tr_ApprovedPassengers: MutableList<ApprovedPassenger>?
     , var Tr_Requests: MutableList<Request>
     , var Tr_DeclinedProfiles: MutableList<Profile>
     , var Tr_TripPreferences: MutableList<Preference>){*/


}