package com.puma.chare.repository

import com.puma.chare.api.RetrofitInstance
import com.puma.chare.models.Car
import com.puma.chare.models.Profile

class Repository {
    suspend fun getProfile(id: String): Profile {
        return RetrofitInstance.api.getProfile(id)
    }
    suspend fun postProfile(profile: Profile): Profile {
        return RetrofitInstance.api.postProfile(profile)
    }

    suspend fun postCar(car: Car): Car {
        return RetrofitInstance.api.postCar(car)
    }
}
