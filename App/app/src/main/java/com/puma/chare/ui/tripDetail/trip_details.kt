package com.puma.chare.ui.tripDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.puma.chare.MainActivity
import com.puma.chare.R
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import com.puma.chare.ui.profile.ProfileViewModel
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor
import java.util.*
import kotlin.math.roundToInt

class trip_details : Fragment() {

   /* companion object {
        fun newInstance() = trip_details()
    }*/

    private lateinit var viewModel: TripDetailsViewModel
    private lateinit var inflatedView: View

    val months = arrayOf("Januari","Februari","Mars","April","Maj","Juni","Juli","Augusti",
        "September","Oktober","November,","December")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.inflatedView = inflater.inflate(R.layout.fragment_trip_details, container, false)
        inflatedView.findViewById<TextView>(R.id.textBack).setOnClickListener {
            val act: MainActivity = activity as MainActivity
            act.backFragments()
        }
        return inflatedView
        /*viewModel = ViewModelProvider(this)[TripDetailsViewModel::class.java]

        // Fetch the trip data.
        val trip: Trip = viewModel.fetchData()

        val inflatedView = inflater.inflate(R.layout.fragment_trip_details, container, false)

        // Get textviews by id from the inflated view.
        val from = inflatedView?.findViewById<TextView>(R.id.textView25)
        val to = inflatedView?.findViewById<TextView>(R.id.textView26)
        val date = inflatedView?.findViewById<TextView>(R.id.textView19)
        val time = inflatedView?.findViewById<TextView>(R.id.textView20)
        val price = inflatedView?.findViewById<TextView>(R.id.textView28)
        val model = inflatedView?.findViewById<TextView>(R.id.textView21)
        val seats = inflatedView?.findViewById<TextView>(R.id.textView22)

        val destinations = trip.Tr_Destinations.split(",")
        val datetime = trip.Tr_Date.toString().split(" ")
        // Set textviews to fetched data.
        from?.text = destinations[0]
        to?.text = destinations[1]
        date?.text = datetime[0]
        time?.text = datetime[1]
        price?.text = trip.Tr_Price.toString()
        model?.text = "SAAB 2000"
        seats?.text = trip.Tr_AvaliableSeats.toString()

        return inflatedView*/
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProvider(activity as MainActivity)[TripDetailsViewModel::class.java]
        //viewModel.getTrip(1 /*Change this to actual id*/)
        viewModel.trip.observe(viewLifecycleOwner) { trip ->
            run {
                val destinations = trip.tr_Destinations.split(":")

                val FMT: DateTimeFormatter = DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
                    .toFormatter()
                    .withZone(ZoneId.of("Europe/Stockholm"))

                // Convert time string to Instant.
                val instant = FMT.parse(
                    trip.tr_DateTime
                ) { temporal: TemporalAccessor? ->
                    Instant.from(
                        temporal
                    )
                }

                val date = Date.from(instant)

                var minutes = instant.atZone(ZoneOffset.UTC).minute.toString()
                if(minutes.toInt() < 10){
                    minutes = "0$minutes"
                }

                setText(R.id.textView25, destinations[0])
                setText(R.id.textView26, destinations[1])
                setText(R.id.textView19, date.date.toString() + " " + months[date.month])
                setText(R.id.textView20, instant.atZone(ZoneOffset.ofHours(2)).hour.toString() + ":" + minutes)
                setText(R.id.textView28, (trip.tr_Price.roundToInt()*13).toString())
                setText(R.id.textView21, trip.tr_Car!!.ca_Model)
                setText(R.id.textView22, trip.tr_AvaliableSeats.toString())
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TripDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setText(id: Int, text: String) {
        inflatedView.findViewById<TextView>(id)?.text = text
    }

}