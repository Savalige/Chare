package com.puma.chare.ui.createUser

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.CreateUserActivity
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateUser4Binding

class CreateUser4 : Fragment() {

    companion object {
        fun newInstance() = CreateUser4()
    }

    private lateinit var viewModel: CreateUser4ViewModel
    private var _binding: FragmentCreateUser4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonUserCreateContinue3
        button.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUser4ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}