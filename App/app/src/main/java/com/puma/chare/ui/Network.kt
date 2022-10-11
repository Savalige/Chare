package com.puma.chare.ui

import android.util.Log
import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.stream.Collectors

class Network {
    companion object {
        /**
         * Performs a GET request.
         * NOTE: call await on Deferred<String> returned by this function to get value.
         *       Must be used inside a coroutine.
         */
        public fun getAsync(url: String): Deferred<String> {
            val connection = URL(url).openConnection() as HttpURLConnection
            return GlobalScope.async {
                try {
                    // Length of buffer is not known beforehand, so setChuckedStreamingMode(0) is set.
                    connection.setChunkedStreamingMode(0)

                    val inputStream: InputStream = connection.inputStream

                    // Create BufferedReader from InputStream.
                    val bf: BufferedReader = BufferedReader(InputStreamReader(inputStream))

                    // Convert BufferedReader to String and return it.
                    return@async bf.lines().collect(Collectors.joining()) as String
                } finally {
                    connection.disconnect()
                }
            }
        }

        /**
         * Performs a GET request.
         * NOTE: call await on Deferred<String> returned by this function to get value.
         *       Must be used inside a coroutine.
         * TODO: Add exception handling.
         */
        public fun deleteAsync(url: String): Deferred<String> {
            val connection = URL(url).openConnection() as HttpURLConnection
            return GlobalScope.async {
                try {
                    connection.requestMethod = "DELETE"
                    // Length of buffer is not known beforehand, so setChuckedStreamingMode(0) is set.
                    connection.setChunkedStreamingMode(0)

                    val inputStream: InputStream = connection.inputStream

                    // Create BufferedReader from InputStream.
                    val bf: BufferedReader = BufferedReader(InputStreamReader(inputStream))

                    // Convert BufferedReader to String and return it.
                    return@async bf.lines().collect(Collectors.joining()) as String
                } finally {
                    connection.disconnect()
                }
            }
        }

        /**
         * Performs a POST.
         * TODO: Add exception handling.
         */
        public fun postAsync(url: String, jsonString: String): Deferred<String> {
            val connection = URL(url).openConnection() as HttpURLConnection
            // GlobalScope.async allows this code to run asynchronously
            return GlobalScope.async {
                try {
                    // Set headers
                    connection.requestMethod = "POST"
                    connection.setRequestProperty("Content-Type", "application/json")
                    connection.setRequestProperty("Accept", "application/json")
                    connection.doOutput = true

                    // Write JSON string to the output stream eg. send the json.
                    // Using 'use' to automatically close and dispose of the output steam.
                    // Similar to using-block in C#
                    connection.outputStream.use { os ->
                        val input: ByteArray = jsonString.toByteArray(Charsets.UTF_8)
                        os.write(input, 0, input.size)
                    }

                    val inputStream: InputStream = connection.inputStream

                    // Create BufferedReader from InputStream.
                    val bf: BufferedReader = BufferedReader(InputStreamReader(inputStream))

                    // Read response from the web server and return it.
                    val response = bf.lines().collect(Collectors.joining(System.lineSeparator()))

                    return@async response
                }
                finally {
                    connection.disconnect()
                }
            }
        }

        /**
         * Performs a POST.
         * TODO: Add exception handling.
         */
        public fun putAsync(url: String, jsonString: String): Deferred<String> {
            val connection = URL(url).openConnection() as HttpURLConnection
            return GlobalScope.async {
                try {
                    // Set headers
                    connection.requestMethod = "PUT"
                    connection.setRequestProperty("Content-Type", "application/json")
                    connection.setRequestProperty("Accept", "application/json")
                    connection.doOutput = true

                    // Write JSON string to the output stream eg. send the json.
                    // Using 'use' to automatically close and dispose of the output steam.
                    // Similar to using-block in C#
                    connection.outputStream.use { os ->
                        val input: ByteArray = jsonString.toByteArray(Charsets.UTF_8)
                        os.write(input, 0, input.size)
                    }

                    val inputStream: InputStream = connection.inputStream

                    // Create BufferedReader from InputStream.
                    val bf: BufferedReader = BufferedReader(InputStreamReader(inputStream))

                    // Read response from the web server and return it.
                    val response = bf.lines().collect(Collectors.joining(System.lineSeparator()))

                    return@async response
                }
                finally {
                    connection.disconnect()
                }
            }
        }
    }
}