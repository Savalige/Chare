package com.puma.chare.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.puma.chare.api.RetrofitInstance
import com.puma.chare.models.Car
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.time.Instant

class Repository {
    suspend fun getProfile(id: String): Profile {
        return RetrofitInstance.api.getProfile(id)
    }
    suspend fun postProfile(profile: Profile): Profile {
        return RetrofitInstance.api.postProfile(profile)
    }

    suspend fun postCar(car: Car): Car {
        val gson = Gson()
        val body: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("cardata", gson.toJson(car))
            .build()
        return RetrofitInstance.api.postCar(body)
    }

    suspend fun getTripsFromSearch(start: String, end: String, datetime: Instant,
                                   preferences: String): ArrayList<Trip> {
        val query = "${start},${end},${datetime.toString()},${preferences}"
        return RetrofitInstance.api.getTripsFromSearch(query)
    }
}
