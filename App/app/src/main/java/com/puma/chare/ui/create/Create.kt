package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.puma.chare.R
import java.util.*

class Create : Fragment() {

    companion object {
        fun newInstance() = Create()
    }

    private lateinit var viewModel: CreateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        val inflatedView = inflater.inflate(R.layout.fragment_create, container, false)

        // Get textviews by id from the inflated view.
        // Changes in UI must be done after view is inflated.
        val origin = inflatedView?.findViewById<EditText>(R.id.inputOrigin)?.text.toString()
        val destination = inflatedView?.findViewById<EditText>(R.id.inputDestination)?.text.toString()
        val date = inflatedView?.findViewById<EditText>(R.id.inputDateField)?.text.toString()
        val time = inflatedView?.findViewById<EditText>(R.id.inputTimeField)?.text.toString()

        // TODO: Pass date from input to part1ToViewModel instead of current date.
        viewModel.part1ToViewModel(origin, destination, Date())

        return inflatedView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}