package com.puma.chare.ui.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.puma.chare.MyApplication
import com.puma.chare.models.Profile
import com.puma.chare.repository.Repository
import com.puma.chare.ui.Network
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ProfileViewModel() : ViewModel() {

    val profile: MutableLiveData<Profile> = MutableLiveData()

    fun getProfile(): Job {
        val repository = Repository()

        return viewModelScope.launch {
            val response = repository.getProfile(MyApplication().profileID.toString())
            profile.value = response
        }
    }
}