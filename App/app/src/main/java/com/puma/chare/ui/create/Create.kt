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
import java.util.*

class Create : Fragment() {

    companion object {
        fun newInstance() = Create()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!


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
            Log.d("Info", "HERE");
            Log.d("Info", binding.inputDate.editText?.text.toString());

            // Get textviews by id from the inflated view.
            // Changes in UI must be done after view is inflated.
            val origin = binding.inputOrigin.text.toString()
            val destination = binding.inputDestination.text.toString()
            val date = binding.inputDateField.text.toString()
            val time = binding.inputTimeField.text.toString()

            Log.d("Info", origin);
            Log.d("Info", destination);

            // TODO: Pass date from input to part1ToViewModel instead of current date.
            viewModel.part1ToViewModel(origin, destination, Date())
            
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.create3Fragment, View.GONE);
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
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}