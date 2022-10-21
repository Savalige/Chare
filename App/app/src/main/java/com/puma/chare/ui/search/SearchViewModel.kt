package com.puma.chare.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.puma.chare.models.Trip
import com.puma.chare.repository.Repository
import com.puma.chare.ui.Network
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant

class SearchViewModel : ViewModel() {

    val trips: MutableLiveData<List<Trip>> = MutableLiveData()

    public fun handleSubmit(origin: String, destination: String, datetime: Instant) {
        val repo = Repository()
        viewModelScope.launch {
            val response = repo.getTripsFromSearch(origin, destination, datetime)
            trips.value = response
        }
    }
}