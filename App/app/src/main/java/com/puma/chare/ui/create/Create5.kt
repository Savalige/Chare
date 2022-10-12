package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.puma.chare.R

class Create5 : Fragment() {

    companion object {
        fun newInstance() = Create5()
    }

    private lateinit var viewModel: CreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        val inflatedView = inflater.inflate(R.layout.fragment_create, container, false)

        val submitButton = inflatedView.findViewById<Button>(R.id.buttonCont)

        // When "fortsätt" button is pressed, submit the data to the API.
        submitButton.setOnClickListener { viewModel.submitForm() }

        return inflatedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}