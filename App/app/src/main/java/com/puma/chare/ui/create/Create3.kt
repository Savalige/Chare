package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.CreateTripActivity
import com.puma.chare.databinding.FragmentCreate3Binding

class Create3 : Fragment() {

    companion object {
        fun newInstance() = Create3()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreate3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreate3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonCont
        button.setOnClickListener {
            val act: CreateTripActivity = activity as CreateTripActivity
            act.replaceFragments(Create4());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}