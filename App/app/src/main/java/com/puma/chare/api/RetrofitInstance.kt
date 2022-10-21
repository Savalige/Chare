package com.puma.chare.api

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        val client : OkHttpClient.Builder = OkHttpClient.Builder()

        client.addInterceptor(logging)

        val gson = GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create()
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5256/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()
    }

    val api: ChareAPI by lazy {
        retrofit.create(ChareAPI::class.java)
    }
}