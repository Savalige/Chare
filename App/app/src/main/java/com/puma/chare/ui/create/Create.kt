package com.puma.chare.ui.create

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateBinding
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor
import java.util.*

class Create : Fragment() {

    companion object {
        fun newInstance() = Create()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!
    private val format: String = "dd.MM.yyyy"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]

        setUpDatePicker()
        setUpTimePicker()

        val button = binding.button
        button.setOnClickListener {
            onButtonPress()
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.create3Fragment, View.VISIBLE);
        }
    }

    private fun setUpDatePicker(){
        val dateEdit = binding.inputDateField
        val formater = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        dateEdit.setText(formater)

        val cal = Calendar.getInstance();

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            dateEdit.setText(sdf.format(cal.time))
        }

        dateEdit.setOnClickListener {
            activity?.let { it1 ->
                DatePickerDialog(
                    it1,dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

    private fun setUpTimePicker(){
        val timeEdit = binding.inputTimeField
        val formater = SimpleDateFormat("HH:mm").format(System.currentTimeMillis())
        timeEdit.setText(formater)

        val cal = Calendar.getInstance();

        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)

            timeEdit.setText(SimpleDateFormat("HH:mm").format(cal.time))
        }


        timeEdit.setOnClickListener {
            activity?.let { it1 ->
                TimePickerDialog(
                    it1,timeSetListener,
                    cal.get(Calendar.HOUR_OF_DAY),
                    cal.get(Calendar.MINUTE),
                    true).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity as MainActivity)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }

    fun onButtonPress() {
        // Get time string from input field
        val dateString = binding.inputDateField.text.toString()
        Log.d("DATE", dateString)
        val timeString = binding.inputTimeField.text.toString()
        Log.d("DATE", timeString)
        val dateTimeString = "$dateString;$timeString"
        Log.d("DATE", dateTimeString)

        val FMT: DateTimeFormatter = DateTimeFormatterBuilder()
            .appendPattern("dd.MM.yyyy;HH:mm")
            .toFormatter()
            .withZone(ZoneId.of("Europe/Stockholm"))

        val inst = FMT.parse(
            dateTimeString
        ) { temporal: TemporalAccessor? ->
            Instant.from(
                temporal
            )
        }
        Log.d("DATE", inst.toString())

        //Log.d("DATE", tripDate.toString())
        viewModel.part1ToViewModel(
            binding.inputOrigin.text.toString(),
            binding.inputDestination.text.toString(),
            inst)
    }
}