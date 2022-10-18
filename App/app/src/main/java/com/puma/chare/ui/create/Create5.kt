package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreate5Binding
import com.puma.chare.ui.search.search

class Create5 : Fragment() {

    companion object {
        fun newInstance() = Create5()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreate5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreate5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonCont
        button.setOnClickListener {
            val act:MainActivity = activity as MainActivity
            act.replaceFragments(search());
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }
}