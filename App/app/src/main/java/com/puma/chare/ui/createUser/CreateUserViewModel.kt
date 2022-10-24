package com.puma.chare.ui.createUser

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puma.chare.MyApplication
import com.puma.chare.models.Car
import com.puma.chare.models.Profile
import com.puma.chare.repository.Repository
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class CreateUserViewModel : ViewModel() {
    private val profile: Profile = Profile()
    private var car: Car = Car()

    fun passFragment1DataToViewModel(firstname: String, lastname: String, birthdate: Instant,
                                     email: String, password: String){
        profile.pr_Firstname = firstname
        profile.pr_Lastname = lastname
        profile.pr_BirthDate = birthdate.toString()
        profile.pr_Email = email
        profile.pr_Password = password
    }
    fun passFragment2DataToViewModel(bio: String){
        profile.pr_Bio = bio
    }
    fun passFragment3DataToViewModel(car: Car){
        this.car = car
    }

    public fun getProfile(): Profile {
        return profile
    }
    public fun getCar(): Car {
        return this.car
    }

    fun submitProfile() {
        val repo = Repository()
        viewModelScope.launch {
            val fetchedProfile: Profile = repo.postProfile(profile)
            MyApplication.profileID = fetchedProfile.pr_Id!!
            car.ca_Owner = fetchedProfile
            val car: Car = repo.postCar(car)
        }
    }
}