package com.puma.chare.ui.create

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.puma.chare.MyApplication
import com.puma.chare.models.Car
import com.puma.chare.models.Preference
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import com.puma.chare.repository.Repository
import com.puma.chare.ui.Network
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant

class CreateViewModel : ViewModel() {

    private val trip: Trip = Trip()

    val car: MutableLiveData<Car> = MutableLiveData()
    var carId: Int = 1

    public fun getTrip(): Trip {
        return trip
    }

    public fun part1ToViewModel(origin: String, destination: String, dateTime: Instant) {
        trip.tr_Destinations = "$origin:$destination"
        trip.tr_DateTime = dateTime.toString().split("Z")[0]
    }

    public fun part2ToViewModel(avaliableSeats: Int, price: Double) {
        val car = Car()
        car.ca_Id = carId

        trip.tr_AvaliableSeats = avaliableSeats
        trip.tr_Car = car
        trip.tr_Price = price
    }

    public fun part4ToViewModel(preferences: MutableList<Preference>) {
        trip.tr_TripPreferences = preferences
    }

    fun getCar(): Job {
        val repository = Repository()

        return viewModelScope.launch {
            val response = repository.getCarFromProfile("1")
            car.value = response[0]
            carId = response[0].ca_Id!!

        }
    }


    fun submitForm() {
        val profile = Profile()
        profile.pr_Id = MyApplication.profileID
        trip.tr_Driver = profile

        val repo = Repository()
        viewModelScope.launch {
            val response = repo.postTrip(trip)
           // if(response.)
            // will go bad.
        }

    }


}