package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreateBinding
import java.util.*

class Create : Fragment() {

    companion object {
        fun newInstance() = Create()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]


        val button = binding.button
        button.setOnClickListener {
            Log.d("Info", "HERE");
            Log.d("Info", binding.inputDate.editText?.text.toString());

            // Get textviews by id from the inflated view.
            // Changes in UI must be done after view is inflated.
            val origin = binding.inputOrigin.text.toString()
            val destination = binding.inputDestination.text.toString()
            val date = binding.inputDateField.text.toString()
            val time = binding.inputTimeField.text.toString()

            Log.d("Info", origin);
            Log.d("Info", destination);

            // TODO: Pass date from input to part1ToViewModel instead of current date.
            viewModel.part1ToViewModel(origin, destination, Date())
            
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.create3Fragment, View.GONE);
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}