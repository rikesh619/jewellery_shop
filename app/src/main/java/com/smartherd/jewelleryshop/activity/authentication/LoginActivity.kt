package com.smartherd.jewelleryshop.activity.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.smartherd.jewelleryshop.R
import com.smartherd.jewelleryshop.activity.SplashActivity
import com.smartherd.jewelleryshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dontHaveAcc.setOnClickListener {
            val intent = Intent(this , SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, SplashActivity :: class.java)
            startActivity(intent)
        }
    }
}