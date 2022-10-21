package com.puma.chare.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.databinding.FragmentSearchBinding
import com.puma.chare.databinding.FragmentSearchResultsBinding
import com.puma.chare.ui.create.CreateViewModel


class SearchResults : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var resultRecyclerView: RecyclerView

    //private lateinit var resultAdapter : SearchAdapter
    private lateinit var views: View
    private var _binding: FragmentSearchResultsBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = SearchResults()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchResultsBinding.inflate(inflater, container, false)
        searchViewModel = ViewModelProvider(activity as MainActivity)[SearchViewModel::class.java]

        searchViewModel.trips.observe(viewLifecycleOwner) { trips ->
            run {
                resultRecyclerView = binding.rvSearchResults
                resultRecyclerView.layoutManager = LinearLayoutManager(activity)
                resultRecyclerView.setHasFixedSize(true)

                resultRecyclerView.adapter = SearchAdapter(trips)
            }
        }

        return binding.root
    }
}