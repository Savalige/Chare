package com.puma.chare.ui.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.puma.chare.models.Profile
import com.puma.chare.ui.Network
import kotlinx.coroutines.runBlocking

class ProfileViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    public fun fetchData(): Profile {
         val jsonString = runBlocking {
             // TODO: Remove hardcoded profile, supply credentials.
             return@runBlocking Network.getAsync("http://10.0.2.2:5256/api/Profile/1").await()
         }
        val gson = GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create()

        return gson.fromJson(jsonString, Profile::class.java)
    }
}