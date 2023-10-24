package com.example.customer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customer.modules.homepage.HomePageActivity
import com.example.customer.modules.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private val sharedPref: SharedPreferences by lazy {
        getSharedPreferences(
            "CustomerPref",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (sharedPref.contains("userId")) {
            startHomeActivity()
        } else {
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomePageActivity::class.java))
        finish()
    }
}