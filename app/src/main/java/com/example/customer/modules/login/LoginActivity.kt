package com.example.customer.modules.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.customer.databinding.ActivityLoginBinding
import com.example.customer.modules.login.viewmodel.LoginViewModel
import com.example.customer.util.hide
import com.example.customer.util.show
import com.example.customer.util.showShortToast

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
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
            if (userData != null) {
                // Login was successful, you have the user data in 'userData'
                binding.root.showShortToast("Login Success")
            } else if (viewModel.isLoginSuccess.value == false) {
                // Login failed
                // Handle the failure, e.g., show an error message
                binding.root.showShortToast("Login Failed")
            }

            binding.pbLogin.hide()
        }
    }

    private fun login() {
        val userName = binding.etUserName.text.toString()
        val userPassword = binding.etPassword.text.toString()

        binding.pbLogin.show()
        viewModel.login(userName, userPassword)


    }

}