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
import android.util.Log
import android.view.MenuItem
import androidx.navigation.NavController
import com.puma.chare.ui.chat.chat
import com.puma.chare.ui.profile.ProfileFragment
import com.puma.chare.ui.search.search
import com.puma.chare.ui.trips.trips


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigationSearch, R.id.navigationCreate, R.id.navigationTrips))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {
            Log.d("Info", "HELLO");

            if (it.itemId == R.id.navigationCreate) {
                val intent = Intent(this, CreateTripActivity::class.java)
                startActivity(intent)
            }
            if (it.itemId == R.id.navigationSearch) {
                navController.navigate(R.id.navigationSearch)
            }
            if (it.itemId == R.id.navigationChat) {
                navController.navigate(R.id.navigationSearchResult)
            }
            if (it.itemId == R.id.navigationTrips) {
                navController.navigate(R.id.navigationTrips)
            }
            if (it.itemId == R.id.navigationProfile) {
                navController.navigate(R.id.navigationProfile)
            }

            true
        }
    }

    public fun replaceFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, fragment)
            commit()
        }
    }
}