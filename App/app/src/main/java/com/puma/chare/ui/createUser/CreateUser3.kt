package com.puma.chare.ui.createUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.CreateUserActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser3Binding
import com.puma.chare.models.Car

class CreateUser3 : Fragment() {

    companion object {
        fun newInstance() = CreateUser3()
    }

    private lateinit var viewModel: CreateUserViewModel
    private var _binding: FragmentCreateUser3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.fragment3NextButton
        button.setOnClickListener {
            submitToViewModel()
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser4());
        }

        val backButton = binding.textBack
        backButton.setOnClickListener {
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser2());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity as CreateUserActivity).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun submitToViewModel() {
        val car = Car()
        car.ca_Model = binding.editCarModel.text.toString()
        car.ca_Color = "Svart"
        car.ca_Seats = binding.editSeatsAvaliable.text.toString().toInt()
        car.ca_Fuel = binding.fuelSwitch.isActivated.toString()
        if(binding.fuelSwitch.isActivated) car.ca_Fuel = "Diesel"
        else car.ca_Fuel = "Bensin"
        // TODO: Remove hardcoded value
        car.ca_FuelCon = 0.7
        viewModel.passFragment3DataToViewModel(car)
    }

}