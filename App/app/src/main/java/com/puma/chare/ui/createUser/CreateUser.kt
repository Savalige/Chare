package com.puma.chare.ui.createUser

import android.content.Intent
import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.puma.chare.CreateTripActivity
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser1Binding
import com.puma.chare.databinding.FragmentLoginBinding
import com.puma.chare.CreateUserActivity
import java.util.*
import com.puma.chare.CreateUserActivity as CreateUser1


class CreateUser : Fragment() {

    companion object {
        fun newInstance() = CreateUser()
    }

    private lateinit var viewModel: CreateUserViewModel
    private var _binding: FragmentCreateUser1Binding? = null
    private val binding get() = _binding!!

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
        viewModel.passFragment1DataToViewModel(
            binding.editUserFirstname.text.toString(),
            binding.editUserLastName.text.toString(),
            binding.editTextDate.text.toString(),
            binding.editTextTextEmailAddress.text.toString(),
            binding.editTextTextPassword.text.toString())
    }

}