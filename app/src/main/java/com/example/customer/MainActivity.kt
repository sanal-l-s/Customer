package com.example.customer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customer.modules.homepage.HomePageActivity
import com.example.customer.modules.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startHomeActivity()
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomePageActivity::class.java))
    }
}