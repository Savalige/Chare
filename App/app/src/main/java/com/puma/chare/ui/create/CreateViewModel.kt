package com.puma.chare.ui.create

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.puma.chare.models.Car
import com.puma.chare.models.Preference
import com.puma.chare.models.Trip
import com.puma.chare.ui.Network
import kotlinx.coroutines.runBlocking
import java.time.Instant

class CreateViewModel : ViewModel() {

    private val trip: Trip = Trip()

    public fun getTrip(): Trip {
        return trip
    }

    public fun part1ToViewModel(origin: String, destination: String, dateTime: Instant) {
        trip.tr_Destinations = "$origin:$destination"
        trip.tr_DateTime = dateTime.toString()
    }

    public fun part2ToViewModel(avaliableSeats: Int) {
        trip.tr_AvaliableSeats = avaliableSeats
    }

    public fun part3ToViewModel() {

    }

    public fun part4ToViewModel(preferences: MutableList<Preference>) {
        trip.tr_TripPreferences = preferences
    }

    // Is called in Create5
    public fun submitForm() {
        /*
        val result = runBlocking {
            return@runBlocking Network.postAsync("url", Gson().toJson(formData)).await()
        }
        Log.d("test", result)
        */
        // Navigate to different page depending on result.
    }
}