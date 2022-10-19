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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFields()

        val button = binding.submitNewProfileButton
        viewModel.submitProfile()
        button.setOnClickListener {
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
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun setFields(){
        val profile = viewModel.getProfile()
        val car = viewModel.getCar()
        binding.nameText.text = profile.pr_Firstname + " " + profile.pr_Lastname
        val diff = Date().time - profile.pr_BirthDate?.time!!
        binding.ageText.text = Date(diff).year.toString()
        binding.bioText.text = profile.pr_Bio
        binding.carModelText.text = car.Ca_Model
        binding.fuelEcoText.text = car.Ca_FuelCon.toString()
        binding.numSeatsText.text = car.Ca_Seats.toString()
    }
}