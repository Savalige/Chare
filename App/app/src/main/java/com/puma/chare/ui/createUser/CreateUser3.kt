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
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun submitToViewModel() {
        val car = Car()
        car.Ca_Model = binding.editCarModel.text.toString()
        car.Ca_Color = "Svart"
        car.Ca_Seats = binding.editSeatsAvaliable.text.toString().toInt()
        car.Ca_Fuel = binding.fuelSwitch.isActivated.toString()
        if(binding.fuelSwitch.isActivated) car.Ca_Fuel = "Diesel"
        else car.Ca_Fuel = "Bensin"
        // TODO: Remove hardcoded value
        car.Ca_FuelCon = 0.7
    }

}