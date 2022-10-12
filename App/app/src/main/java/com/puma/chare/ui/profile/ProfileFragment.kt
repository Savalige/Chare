package com.puma.chare.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puma.chare.R
import com.puma.chare.models.Profile
import com.puma.chare.ui.search.SearchViewModel

class ProfileFragment : Fragment() {

    lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        // Fetch the profile data.
        val profile: Profile = profileViewModel.fetchData()

        val inflatedView = inflater.inflate(R.layout.fragment_profile2, container, false)

        // Get textviews by id from the inflated view.
        val title = inflatedView?.findViewById<TextView>(R.id.userName)
        val tripsAmount = inflatedView?.findViewById<TextView>(R.id.tripsAmount)
        val drivenAmount = inflatedView?.findViewById<TextView>(R.id.amountDriven)
        val traveledAmount = inflatedView?.findViewById<TextView>(R.id.amountTraveled)
        val bio = inflatedView?.findViewById<TextView>(R.id.bioText)

        // Set textviews to fetched data.
        title?.text = profile.pr_Firstname + " " + profile.pr_Lastname
        tripsAmount?.text = profile.pr_RideNum.toString()
        drivenAmount?.text = profile.pr_DriveDistance.toString()
        traveledAmount?.text = profile.pr_RideDistance.toString()
        bio?.text = profile.pr_Bio

        return inflatedView
    }
}