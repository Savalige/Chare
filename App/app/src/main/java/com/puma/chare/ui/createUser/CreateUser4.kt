package com.puma.chare.ui.createUser

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.CreateUserActivity
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser4Binding
import java.time.Instant
import java.time.LocalDate
import java.util.*

class CreateUser4 : Fragment() {

    companion object {
        fun newInstance() = CreateUser4()
    }

    private lateinit var viewModel: CreateUserViewModel
    private var _binding: FragmentCreateUser4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser4Binding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(activity as CreateUserActivity)[CreateUserViewModel::class.java]
        return binding.root
    }

    /*override fun onResume() {
        super.onResume()
        setFields()
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFields()

        val button = binding.submitNewProfileButton
        button.setOnClickListener {
            viewModel.submitProfile()
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        val backButton = binding.textBack
        backButton.setOnClickListener {
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser3());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    fun setFields(){
        val profile = viewModel.getProfile()
        val car = viewModel.getCar()
        binding.nameText.text = profile.pr_Firstname + " " + profile.pr_Lastname
        val age = Date.from(Instant.now()).year - Date.from(Instant.parse(profile.pr_BirthDate)).year
        binding.ageText.text = "$age år"
        binding.bioText.text = profile.pr_Bio
        binding.carModelText.text = car.Ca_Model
        binding.fuelEcoText.text = car.Ca_FuelCon.toString() + " liter / mil"
        binding.numSeatsText.text = car.Ca_Seats.toString() + " lediga säten"
    }
}