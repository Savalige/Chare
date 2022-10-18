package com.puma.chare.repository

import com.puma.chare.api.RetrofitInstance
import com.puma.chare.models.Profile

class Repository {
    suspend fun getProfile(id: String): Profile {
        return RetrofitInstance.api.getProfile(id)
    }
    suspend fun postProfile(profile: Profile) {
        return RetrofitInstance.api.postProfile(profile)
    }
}
