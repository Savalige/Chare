package com.puma.chare.ui.tripDetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import com.puma.chare.repository.Repository
import com.puma.chare.ui.Network
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TripDetailsViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val trip: MutableLiveData<Trip> = MutableLiveData()

    fun getTrip(id: Int): Job {
        val repository = Repository()

        return viewModelScope.launch {
            val response = repository.getTrip(id.toString())
            trip.value = response
        }
    }
}