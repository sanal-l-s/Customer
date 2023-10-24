package com.example.customer.signuppage.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.customer.databinding.ActivityLoginBinding
import com.example.customer.modules.homepage.HomePageActivity
import com.example.customer.modules.login.model.UserData
import com.example.customer.modules.login.viewmodel.LoginViewModel
import com.example.customer.util.hide
import com.example.customer.util.show
import com.example.customer.util.showShortToast

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    private val sharedPref: SharedPreferences by lazy {
        getSharedPreferences(
            "CustomerPref",
            Context.MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        binding.btnLogin.setOnClickListener {
            login()
        }
        observeUserdata()


    }

    private fun observeUserdata() {
        viewModel.userData.observe(this) { userData ->
            storeUserData(userData)

            if (userData != null) {
                // Login was successful, you have the user data in 'userData'
                binding.root.showShortToast("Login Success")

                startHomeActivity()

            } else if (viewModel.isLoginSuccess.value == false) {
                // Login failed
                // Handle the failure, e.g., show an error message
                binding.root.showShortToast("Login Failed")
            }

            storeUserData(userData)

            binding.pbLogin.hide()
        }
    }

    private fun storeUserData(userData: UserData?) {
        sharedPref.edit().apply {
            putString("userId", userData?.userId)
            putString("userName", userData?.userName)
            putString("userPhone", userData?.userPhone)
            putString("userMail", userData?.userMail)
        }.apply()
    }

    private fun login() {
        val userName = binding.etUserName.text.toString()
        val userPassword = binding.etPassword.text.toString()

        binding.pbLogin.show()
        viewModel.login(userName, userPassword)


    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomePageActivity::class.java))
        finish()
    }


}