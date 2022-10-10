package com.puma.chare.ui

import android.provider.Settings.Global
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

class Network(url: String) {
    lateinit var url: URL
    lateinit var connection: HttpURLConnection

    init {
        this.url = URL(url)
        this.connection = this.url.openConnection() as HttpURLConnection
    }

    /**
     * Performs a GET request.
     * NOTE: call await on Deferred<String> returned by this function to get value.
     *       Must be used inside a coroutine.
     */
    public fun getAsync(): Deferred<String> = GlobalScope.async {
        try {
            // Length of buffer is not known beforehand, so setChuckedStreamingMode(0) is set.
            connection.setChunkedStreamingMode(0)

            val inputStream: InputStream = connection.inputStream

            // Create BufferedReader from InputStream.
            val bf: BufferedReader = BufferedReader(InputStreamReader(inputStream))

            val gson: Gson = Gson()

            // Convert BufferedReader to String and return it.
            return@async bf.lines().collect(Collectors.joining()) as String
        }
        finally {
            connection.disconnect()
    }
}

    public fun Post() = GlobalScope.async {
    }

    public fun Delete() {

    }

}