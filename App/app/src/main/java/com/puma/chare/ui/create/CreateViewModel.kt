package com.puma.chare.ui.create

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.puma.chare.models.Car
import com.puma.chare.models.Preference
import com.puma.chare.ui.Network
import kotlinx.coroutines.runBlocking
import java.text.Normalizer.Form
import java.util.Date

class CreateViewModel : ViewModel() {

    // Names might have to be changed to fit json format that the api wants.
    class FormData {
        // Part 1 - Route and time
        var origin: String? = null
        var destination: String? = null
        var dateTime: Date? = null
        // Part 2 - Route options

        // Part 3 - Seating and price
        var numOfSeats: Int? = null
        var milePrice: Float? = null
        var car: Car? = null

        // Part 4 - Driver preferences
        var preferences: ArrayList<Preference> = ArrayList<Preference>()
    }

    var formData: FormData = FormData()

    public fun part1ToViewModel(origin: String, destination: String, dateTime: Date) {
        formData.origin = origin
        formData.destination = destination
        formData.dateTime = dateTime
    }
    public fun part2ToViewModel() {

    }
    public fun part3ToViewModel(numOfSeats: Int, milePrice: Float, car: Car) {
        formData.numOfSeats = numOfSeats
        formData.milePrice = milePrice
        formData.car = car
    }
    public fun part4ToViewModel(preferences: ArrayList<Preference>) {

    }

    // Is called in Create5
    public fun submitForm() {
        val result = runBlocking {
            return@runBlocking Network.postAsync("url", Gson().toJson(formData)).await()
        }
        Log.d("test", result)

        // Navigate to different page depending on result.
    }
}