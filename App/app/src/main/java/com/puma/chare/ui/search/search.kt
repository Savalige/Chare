package com.puma.chare.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.puma.chare.R

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide the actionbar.
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        // Inflate view.
        val view = inflater.inflate(com.puma.chare.R.layout.fragment_search, container, false)

        // Get Button from inflated view.
        val button: Button = view.findViewById(R.id.submitButton)

        // Add eventListener on Button.
        button.setOnClickListener { onSubmit(view) }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    private fun onSubmit(view: View) {
        originInput = view.findViewById(R.id.origin_input)
        destinationInput = view.findViewById(R.id.destination_input)

        val origin = originInput.text.toString()
        val destination = destinationInput.text.toString()

        // Origin and destination is ready to be used.
        // Eg. send to next view or to API for processing.
        searchViewModel.handleSubmit(origin, destination)
    }
}