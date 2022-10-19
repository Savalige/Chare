package com.puma.chare.api

import com.puma.chare.models.Profile
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ChareAPI {
    @GET("Profile/{id}")
    suspend fun getProfile(@Path("id") id: String): Profile

    @POST("Profile")
    suspend fun postProfile(profile: Profile)
}