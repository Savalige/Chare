package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreate3Binding
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor

class Create3 : Fragment() {

    companion object {
        fun newInstance() = Create3()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreate3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreate3Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        viewModel.getCar()
        viewModel.car.observe(viewLifecycleOwner) { car ->
            run {
               // Log.d("test", profile.pr_Firstname)
                binding.textView10.text = car.ca_Model.toString()
                binding.textView11.text = car.ca_FuelCon.toString() + " liter " + car.ca_Fuel
                binding.editTextNumber.setText(car.ca_Seats.toString())
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonCont
        button.setOnClickListener {
            onButtonPress()
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.create4Fragment, View.VISIBLE);
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity as MainActivity)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }

    fun onButtonPress() {
        //Log.d("DATE", tripDate.toString())
        val price = binding.textView15.text.toString().split(" ")[0]
        viewModel.part2ToViewModel(binding.editTextNumber.text.toString().toInt(),price.toDouble())
    }
}