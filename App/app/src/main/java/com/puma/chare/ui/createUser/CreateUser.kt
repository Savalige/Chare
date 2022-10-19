package com.puma.chare.ui.createUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser1Binding
import com.puma.chare.databinding.FragmentLoginBinding
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
            val act:CreateUser1 = activity as com.puma.chare.CreateUserActivity
            act.replaceFragments(CreateUser2());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUserViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun onButtonPress() {
        viewModel.passFragment1DataToViewModel(
            binding.editUserFirstname.toString(),
            binding.editUserLastName.toString(),
            binding.editTextDate.toString(),
            binding.editTextTextEmailAddress.toString(),
            binding.editTextTextPassword.toString())
    }

}