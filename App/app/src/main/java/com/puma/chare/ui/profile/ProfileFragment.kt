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
    lateinit var inflatedView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflatedView = inflater.inflate(R.layout.fragment_profile2, container, false)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.getProfile()
        profileViewModel.profile.observe(viewLifecycleOwner) { profile ->
            run {
                Log.d("test", profile.pr_Firstname)
                setText(R.id.userName, profile.pr_Firstname + ' ' + profile.pr_Lastname)
                setText(R.id.bioText, profile.pr_Bio)
                setText(R.id.tripsAmount, profile.pr_RideNum.toString())
                setText(R.id.amountDriven, profile.pr_DriveDistance.toString())
                setText(R.id.amountTraveled, profile.pr_RideDistance.toString())
            }
        }
        return inflatedView
    }

    private fun setText(id: Int, text: String) {
        inflatedView.findViewById<TextView>(id)?.text = text
    }
}