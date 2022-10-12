package com.puma.chare.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.puma.chare.ui.Network
import kotlinx.coroutines.runBlocking

class SearchViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val url: String = "http://10.0.2.2:5256/api/"

    public fun handleSubmit(origin: String, destination: String) {
        val result: String = runBlocking { return@runBlocking Network.getAsync(url + "Profile/1").await() }
    }
}