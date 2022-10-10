package com.puma.chare.ui.createUser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.R

class CreateUser2 : Fragment() {

    companion object {
        fun newInstance() = CreateUser2()
    }

    private lateinit var viewModel: CreateUser2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_user_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateUser2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}