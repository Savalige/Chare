package com.puma.chare.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.textfield.TextInputEditText
import com.puma.chare.R
import com.puma.chare.ui.Network
import kotlinx.coroutines.*

class Test(test: Int) {
    val test: Int = test
}

class search : Fragment() {

    companion object {
        fun newInstance() = search()
    }

    private lateinit var viewModel: SearchViewModel
    private lateinit var originInput: TextInputEditText
    private lateinit var destinationInput: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide the actionbar.
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        //SearchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        // Inflate view.
        val view = inflater.inflate(com.puma.chare.R.layout.fragment_search, container, false)

        // Get Button from inflated view.
        val button: Button = view.findViewById(R.id.submitButton)

        // Add eventListener on Button.
        button.setOnClickListener { onSubmit(view)}
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun onSubmit(view: View) {
        originInput = view.findViewById(R.id.origin_input)
        destinationInput = view.findViewById(R.id.destination_input)

        val origin = originInput.text
        val destination = destinationInput.text

        // Origin and destination is ready to be used.
        // Eg. send to next view or to API for processing.
        Log.d("ok: ", "$origin")

        //val network: Network = Network("http://10.0.2.2:7256/api/Profile/1")
        val network: Network = Network("https://jsonplaceholder.typicode.com/posts/1/comments")

        val result: String = runBlocking { return@runBlocking network.getAsync().await() }
        Log.d("test", result)
    }
}