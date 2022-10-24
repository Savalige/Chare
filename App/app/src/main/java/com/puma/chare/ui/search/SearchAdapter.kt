package com.puma.chare.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.models.Trip
import com.puma.chare.ui.tripDetail.TripDetailsViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.util.*

class SearchAdapter (private val searchResult: List<Trip>, private val activity: MainActivity) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_trip, parent, false)
        return SearchViewHolder(itemView)
    }

    val months = arrayOf("Januari","Februari","Mars","April","Maj","Juni","Juli","Augusti",
        "September","Oktober","November,","December")

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentItem = searchResult[position]

        val path = currentItem.tr_Destinations.split(":")

        val FMT: DateTimeFormatter = DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .toFormatter()
            .withZone(ZoneId.of("Europe/Stockholm"))

        // Convert time string to Instant.
        val instant = FMT.parse(
            currentItem.tr_DateTime
        ) { temporal: TemporalAccessor? ->
            Instant.from(
                temporal
            )
        }

        val date = Date.from(instant)

        holder.startLocation.text = path[0]
        holder.endLocation.text = path.last()
        holder.availableSeats.text = currentItem.tr_AvaliableSeats.toString()
        holder.date.text = date.date.toString() + " " + months[date.month]
        holder.time.text = instant.atZone(ZoneOffset.ofHours(2)).hour.toString() + ":" + instant.atZone(ZoneOffset.UTC).minute
        holder.cost.text = currentItem.tr_Price.toInt().toString() + "kr"
        holder.itemView.setOnClickListener {
            ViewModelProvider(activity)[TripDetailsViewModel::class.java].getTrip(currentItem.tr_Id!!)
            val act: MainActivity = activity
            act.replaceFragments(R.id.navigationTripDetail, View.GONE);
        }
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