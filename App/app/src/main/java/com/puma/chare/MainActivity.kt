package com.puma.chare

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.puma.chare.databinding.ActivityMainBinding


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
                navController.navigate(R.id.navigationProfile)
            }

            true
        }
        if (MyApplication.profileID == -1) {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }
    }

    public fun replaceFragments(id: Int, visibility : Int = View.VISIBLE) {
        navController.navigate(id)
        val navView: BottomNavigationView = binding.navView
        navView.visibility = visibility
    }

    public fun backFragments(visibility : Int = View.VISIBLE) {
        this.onBackPressed()
        val navView: BottomNavigationView = binding.navView
        navView.visibility = visibility
    }
}

class MyApplication : Application() {
    companion object {
        @JvmField
        var profileID: Int = -1
    }
}