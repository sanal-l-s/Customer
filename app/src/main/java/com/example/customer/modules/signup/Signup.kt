package com.example.customer.modules.signup

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.customer.R
import com.example.customer.modules.signup.model.UserData
import com.example.customer.modules.signup.viewmodel.SignUpViewModel


class Signup : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        val username = findViewById<EditText>(R.id.username)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val password = findViewById<EditText>(R.id.password)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpViewModel.signup.observe(this){

            Log.d("RESPONSE:",it.email)
        }

        signUpButton.setOnClickListener {
            val username = username.text.toString()
            val email = email.text.toString()
            val phone = phone.text.toString().toInt()
            val password = password.text.toString()


                try {
                     val userData = UserData( username, email, phone, password)

                    signUpViewModel.fetchSignup(userData)


                } catch (e: Exception) {
                    Log.e("SignupActivity", "Error: ${e.message}")
                    e.printStackTrace()
                }


        }
    }
}