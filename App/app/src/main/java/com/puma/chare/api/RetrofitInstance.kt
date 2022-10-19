package com.puma.chare.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        val gson = GsonBuilder().setDateFormat("yyyy-mm-dd'T'HH:mm:ss").create()
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5256/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: ChareAPI by lazy {
        retrofit.create(ChareAPI::class.java)
    }
}