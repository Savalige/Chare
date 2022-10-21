package com.puma.chare.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.puma.chare.R
import com.puma.chare.models.Trip

class SearchAdapter (private val searchResult: List<Trip>) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_trip, parent, false)
        return SearchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentItem = searchResult[position]
        holder.startLocation.text = currentItem.Tr_Destinations
        holder.endLocation.text = "Karesuando"
        holder.availableSeats.text = "123"
        holder.date.text = "24 december"
        holder.time.text = "15:00"
        holder.cost.text = "1337" + " kr"
    }

    override fun getItemCount(): Int {
        return searchResult.size
    }

    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startLocation : TextView = itemView.findViewById(R.id.tripTitle)
        val endLocation : TextView = itemView.findViewById(R.id.tripTitle2)
        val date : TextView = itemView.findViewById(R.id.tripDate)
        val time : TextView = itemView.findViewById(R.id.tripTime)
        val availableSeats : TextView = itemView.findViewById(R.id.tripSeatsAvailable)
        val cost : TextView = itemView.findViewById(R.id.tripCost)
        val preferenceList : ImageView = itemView.findViewById(R.id.tripicon1)
    }

}