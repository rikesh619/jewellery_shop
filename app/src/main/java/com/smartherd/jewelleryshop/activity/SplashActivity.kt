package com.smartherd.jewelleryshop.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.databinding.ActivitySplashBinding
import com.smartherd.jewelleryshop.tabbar.HomeFragment

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.splashForwardBtn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            this.startActivity(intent)
        }


    }
}