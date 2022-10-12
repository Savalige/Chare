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
import com.puma.chare.databinding.FragmentCreateUser3Binding

class CreateUser3 : Fragment() {

    companion object {
        fun newInstance() = CreateUser3()
    }

    private lateinit var viewModel: CreateUser3ViewModel
    private var _binding: FragmentCreateUser3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUser3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonUserCreateContinue3
        button.setOnClickListener {
            val act: CreateUserActivity = activity as CreateUserActivity
            act.replaceFragments(CreateUser4());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUser3ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}