package com.puma.chare.api

import com.puma.chare.models.Car
import com.puma.chare.models.Profile
import com.puma.chare.models.Request
import okhttp3.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ChareAPI {
    @GET("Profile/{id}")
    suspend fun getProfile(@Path("id") id: String): Profile

    @POST("Profile")
    suspend fun postProfile(@Body profile: Profile): Profile

    @POST("Car")
    suspend fun postCar(@Body car: RequestBody): Car
}