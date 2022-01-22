package com.example.forcast_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.forcast_app.R
import com.example.forcast_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflating layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        // set binded layout as content view
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        //Inside OnCreate supportFragmentManager with findFragmentById however outside it Navigation.findNavController works
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // binding bottomNav bar with navigation controller
        binding.bottomNav.setupWithNavController(navController)

        // binding Navigation UI with navigation controller
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // navigateUp is arrow which leads us back to previous/home fragment onclick
        return NavigationUI.navigateUp(navController,null)

    }
}