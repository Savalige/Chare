package com.puma.chare.ui.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentCreate4Binding
import com.puma.chare.models.Preference

class Create4 : Fragment() {

    companion object {
        fun newInstance() = Create4()
    }

    private lateinit var viewModel: CreateViewModel
    private var _binding: FragmentCreate4Binding? = null
    private val binding get() = _binding!!
    private val preferences = mutableListOf<Preference>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreate4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonCont
        button.setOnClickListener {
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.create5Fragment, View.VISIBLE);
        }

        val back = binding.textBack
        back.setOnClickListener {
            val act: MainActivity = activity as MainActivity
            act.replaceFragments(R.id.navigationCreate, View.GONE);
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(activity as MainActivity)[CreateViewModel::class.java]
        // TODO: Use the ViewModel
    }

    fun onButtonPress() {
        //Log.d("DATE", tripDate.toString())
        viewModel.part4ToViewModel(preferences)
    }
}