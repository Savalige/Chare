package com.puma.chare.ui.createUser

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puma.chare.CreateUserActivity
import com.puma.chare.databinding.FragmentCreateUser1Binding
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.util.*


class CreateUser : Fragment() {

    companion object {
        fun newInstance() = CreateUser()
    }

    private lateinit var viewModel: CreateUserViewModel
    private var _binding: FragmentCreateUser1Binding? = null
    private val binding get() = _binding!!
    private val format: String = "dd.MM.yyyy"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.userCreateButtonContinue1
        button.setOnClickListener {
            onButtonPress()
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser2());
        }

        val dateEdit = binding.editTextDate
        val formater = SimpleDateFormat(format).format(System.currentTimeMillis())
        dateEdit.setText(formater)

        val cal = Calendar.getInstance();

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            // mention the format you need
            val sdf = SimpleDateFormat(format, Locale.US)
            dateEdit.setText(sdf.format(cal.time))
        }

        dateEdit.setOnClickListener {
            Log.d("info","hej")
            activity?.let { it1 ->
                DatePickerDialog(
                    it1,dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity as CreateUserActivity).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun onButtonPress() {
        // Get time string from input field.
        val timeString: String = binding.editTextDate.text.toString()

        val FMT: DateTimeFormatter = DateTimeFormatterBuilder()
            .appendPattern(format)
            .parseDefaulting(ChronoField.NANO_OF_DAY, 0)
            .toFormatter()
            .withZone(ZoneId.of("Europe/Stockholm"))

        // Convert time strint to Instant.
        val instant = FMT.parse(
            timeString
        ) { temporal: TemporalAccessor? ->
            Instant.from(
                temporal
            )
        }

        viewModel.passFragment1DataToViewModel(
            binding.editUserFirstname.text.toString(),
            binding.editUserLastName.text.toString(),
            instant,
            binding.editTextTextEmailAddress.text.toString(),
            binding.editTextTextPassword.text.toString())
    }

}