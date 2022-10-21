package com.puma.chare.ui.search

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateBinding
import com.puma.chare.databinding.FragmentSearchBinding
import com.puma.chare.ui.create.Create3
import com.puma.chare.ui.create.CreateViewModel
import java.util.*

class Test(test: Int) {
    val test: Int = test
}

class search : Fragment() {

    companion object {
        fun newInstance() = search()
    }

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var originInput: TextInputEditText
    private lateinit var destinationInput: TextInputEditText

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide the actionbar.
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        // Get Button from inflated view.
        val button: Button = binding.submitButton
        // Add eventListener on Button.
        button.setOnClickListener { onSubmit() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        setUpDatePicker()
        setUpTimePicker()
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    private fun onSubmit() {
       // originInput = view.findViewById(R.id.origin_input)
        originInput = binding.originInput;
        destinationInput = binding.destinationInput;
        //destinationInput = view.findViewById(R.id.destination_input)

        val origin = originInput.text.toString()
        val destination = destinationInput.text.toString()

        // Origin and destination is ready to be used.
        // Eg. send to next view or to API for processing.
        searchViewModel.handleSubmit(origin, destination)
    }

    private fun setUpDatePicker(){
        val dateEdit = binding.editTextDateSearch
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
        val timeEdit = binding.editTextTimeSearch
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
}