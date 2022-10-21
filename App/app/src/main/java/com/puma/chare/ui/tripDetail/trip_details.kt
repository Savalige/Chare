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
import com.puma.chare.R
import com.puma.chare.models.Profile
import com.puma.chare.models.Trip
import com.puma.chare.ui.profile.ProfileViewModel

class trip_details : Fragment() {

    companion object {
        fun newInstance() = trip_details()
    }

    private lateinit var viewModel: TripDetailsViewModel
    private lateinit var inflatedView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.inflatedView = inflater.inflate(R.layout.fragment_trip_details, container, false)

        viewModel = ViewModelProvider(this)[TripDetailsViewModel::class.java]
        viewModel.getTrip()
        viewModel.trip.observe(viewLifecycleOwner) { trip ->
            run {
                //Log.d("test", profile.pr_Firstname)
                val destinations = trip.Tr_Destinations.split(":")
                val datetime = trip.Tr_Date.toString().split(" ")

                setText(R.id.textView25, destinations[0])
                setText(R.id.textView26, destinations[1])
                setText(R.id.textView19, datetime[0])
                setText(R.id.textView20, datetime[1])
                setText(R.id.textView28, trip.Tr_Price.toString())
                setText(R.id.textView21, "Volvo V90")
                setText(R.id.textView22, trip.Tr_AvaliableSeats.toString())
            }
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TripDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setText(id: Int, text: String) {
        inflatedView.findViewById<TextView>(id)?.text = text
    }

}