package com.smartherd.jewelleryshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.databinding.ActivityDashboardBinding
import java.lang.ref.WeakReference

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabBar : BottomNavigationView = binding.tabBar

        val navController = findNavController(R.id.nav_host_fragment_activity_dashboard)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.tab_bar_home,
                R.id.tab_bar_favorites,
                R.id.tab_bar_news,
                R.id.tab_bar_myprofile
            )
        )

        navController.addOnDestinationChangedListener {navController , destination , _ ->
            val weakSelf = WeakReference(this)

            when(destination.id){
                R.id.tab_bar_favorites -> {

                }
                R.id.tab_bar_news -> {

                }
                R.id.tab_bar_myprofile -> {

                }

            }
        }
        tabBar.setupWithNavController(navController)
    }
}