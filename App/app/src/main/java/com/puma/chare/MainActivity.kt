package com.puma.chare

import android.app.Activity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.puma.chare.databinding.ActivityMainBinding

import android.content.Intent
import android.opengl.Visibility
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import com.puma.chare.ui.chat.chat
import com.puma.chare.ui.profile.ProfileFragment
import com.puma.chare.ui.search.search
import com.puma.chare.ui.trips.trips


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigationSearch, R.id.navigationCreate, R.id.navigationTrips))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {
            Log.d("Info", "HELLO");

            if (it.itemId == R.id.navigationCreate) {
                navController.navigate(R.id.navigationCreate)
            }
            if (it.itemId == R.id.navigationSearch) {
                navController.navigate(R.id.navigationSearch)
            }
            if (it.itemId == R.id.navigationChat) {
                navController.navigate(R.id.navigationSearchResult)
            }
            if (it.itemId == R.id.navigationTrips) {
                navController.navigate(R.id.navigationTripDetail)
            }
            if (it.itemId == R.id.navigationProfile) {
                val intent = Intent(this, CreateUserActivity::class.java)
                startActivity(intent)
            }

            true
        }
    }

    public fun replaceFragments(id: Int, visibility: Int) {
        navController.navigate(id)
        val navView: BottomNavigationView = binding.navView
        navView.visibility = visibility
    }
}