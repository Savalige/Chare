package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreate5Binding
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor
import java.util.*

class Create5 : Fragment() {

    companion object {
        fun newInstance() = Create5()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreate5Binding? = null
    private val binding get() = _binding!!

    val months = arrayOf("Januari","Februari","Mars","April","Maj","Juni","Juli","Augusti",
        "September","Oktober","November,","December")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreate5Binding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(activity as MainActivity)[CreateViewModel::class.java]
        setFields()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonCont
        button.setOnClickListener {
            val act: MainActivity = activity as MainActivity
            viewModel.submitForm()
            act.replaceFragments(R.id.navigationSearch, View.VISIBLE);
        }
    }


    fun setFields(){
        val trip = viewModel.getTrip()
        val destinations = trip.tr_Destinations.split(":")

        val FMT: DateTimeFormatter = DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .toFormatter()
            .withZone(ZoneId.of("Europe/Stockholm"))

        // Convert time string to Instant.
        val instant = FMT.parse(
            trip.tr_DateTime
        ) { temporal: TemporalAccessor? ->
            Instant.from(
                temporal
            )
        }

        val dateTime = Date.from(instant)

        viewModel.getCar()
        viewModel.car.observe(viewLifecycleOwner) {car ->
            run {
                binding.textView21.text = car.ca_Model
            }
        }

        binding.dispFrom.text = destinations[0]
        binding.dispTo.text = destinations.last()
        binding.textView4.text = ""
        binding.textView18.text = ""
        binding.textView19.text = dateTime.date.toString() + " " + months[dateTime.month]
        binding.textView20.text = instant.atZone(ZoneOffset.ofHours(4)).hour.toString() +
                ":" + instant.atZone(ZoneOffset.UTC).minute
        binding.textView22.text = trip.tr_AvaliableSeats.toString()
        binding.textView21.text = trip.tr_Car?.ca_Model
        binding.textView24.text = "Inga valda preferenser"

    }
}