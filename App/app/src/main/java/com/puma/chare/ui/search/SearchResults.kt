package com.puma.chare.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.puma.chare.R


class SearchResults : Fragment() {

    private lateinit var searchResultsViewModel: SearchResultsViewModel
    private lateinit var resultRecyclerView : RecyclerView
    //private lateinit var resultAdapter : SearchAdapter
    private lateinit var views : View

    companion object {
        fun newInstance() = SearchResults()
    }

    private lateinit var viewModel : SearchResultsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchResultsViewModel = ViewModelProvider(this).get(SearchResultsViewModel::class.java)
        val ad = searchResultsViewModel.getAllTrips()

        //setUpRecycler()
        views = inflater.inflate(com.puma.chare.R.layout.fragment_search_results, container, false)
        //
        resultRecyclerView = views!!.findViewById(R.id.rvSearchResults)
        resultRecyclerView.layoutManager = LinearLayoutManager(activity)
        resultRecyclerView.setHasFixedSize(true)

        resultRecyclerView.adapter = SearchAdapter(ad)

        //
        return views
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchResultsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            view.findViewById<View>(R.id.rvSearchResults).apply {

                //resultRecyclerView.setAdapter(resultAdapter)
            }

        }

    /*
    private fun setUpRecycler() {
        resultRecyclerView = views!!.findViewById(R.id.rvSearchResults)
        resultRecyclerView.layoutManager = LinearLayoutManager(resultRecyclerView.context)
        resultRecyclerView.setHasFixedSize(true)

        resultAdapter = SearchAdapter()
        resultRecyclerView.setAdapter(resultAdapter)
    }*/

}