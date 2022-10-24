package com.puma.chare.api

import com.puma.chare.models.*
import okhttp3.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.time.Instant


interface ChareAPI {
    @GET("Profile/{id}")
    suspend fun getProfile(@Path("id") id: String): Profile

    @GET("Trip/Search")
    suspend fun getTripsFromSearch(@Query("start")start: String,
                                   @Query("end")end: String,
                                   @Query("time")datetime: String): ArrayList<Trip>

    @GET("Trip/{id}")
    suspend fun getTrip(@Path("id") id: String): Trip

    @POST("Trip")
    suspend fun postTrip(@Body trip: RequestBody): Trip

    @POST("Profile")
    suspend fun postProfile(@Body profile: Profile): Profile

    @POST("Car")
    suspend fun postCar(@Body car: RequestBody): Car

    @GET("Car/Profile/{id}")
    suspend fun getCarFromProfile(@Path("id") id: String): List<Car>


}