package com.puma.chare.ui.tripDetail

import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import com.puma.chare.ui.Network
import kotlinx.coroutines.runBlocking

class TripDetailsViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    public fun fetchData(): Trip {
        val jsonString = runBlocking {
            // TODO: Remove hardcoded profile, supply credentials.
            return@runBlocking Network.getAsync("http://10.0.2.2:5256/api/Trip/1").await()
        }
        val gson = GsonBuilder().setDateFormat("yyyy-mm-dd HH:mm:ss").create()

        return gson.fromJson(jsonString, Trip::class.java)
    }
}