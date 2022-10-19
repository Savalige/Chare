package com.puma.chare.ui.createUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.CreateUserActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser2Binding

class CreateUser2 : Fragment() {

    companion object {
        fun newInstance() = CreateUser2()
    }

    private lateinit var viewModel: CreateUserViewModel
    private var _binding: FragmentCreateUser2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.fragment2NextButton
        button.setOnClickListener {
            submitDataToViewModel()
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser3());
        }

        val backButton = binding.textBack
        backButton.setOnClickListener {
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun submitDataToViewModel() {
        viewModel.passFragment2DataToViewModel(binding.editTextTextMultiLine.text.toString())

    }

}