package com.puma.chare.ui.createUser

import androidx.lifecycle.ViewModel
import com.puma.chare.models.Car
import com.puma.chare.models.Profile
import java.util.Date

class CreateUserViewModel : ViewModel() {
    private val profile: Profile = Profile()
    private lateinit var car: Car

    fun passFragment1DataToViewModel(firstname: String,lastname: String, birthdate: String,
                                     email: String, password: String){
        profile.pr_Firstname = firstname
        profile.pr_Lastname = lastname
        // TODO: Remove hardocded date.
        profile.pr_BirthDate = Date()
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
        return car
    }

    fun submitProfile() {

    }
}