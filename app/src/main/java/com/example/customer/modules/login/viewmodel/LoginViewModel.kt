package com.example.customer.modules.login.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customer.modules.login.model.UserData
import com.example.customer.network.CustomerApiHelper
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val _userData = MutableLiveData<UserData?>()
    val userData: MutableLiveData<UserData?> get() = _userData

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess: MutableLiveData<Boolean> get() = _isLoginSuccess

    fun login(userName: String, userPassword: String) {
        viewModelScope.launch {
            val response: Response<List<UserData>> =
                CustomerApiHelper.api.login(userName, userPassword)
            if (response.isSuccessful) {
                val userResponse = response.body()
                if (!userResponse.isNullOrEmpty()) {
                    _userData.value = userResponse.first()
                    _isLoginSuccess.value = true
                } else {
                    _userData.value = null
                    _isLoginSuccess.value = false
                }
            } else {
                // Handle the error condition, e.g., show an error message
                Log.e("LoginViewModel", "Error: ${response.code()} - ${response.message()}")
                _userData.value = null
                _isLoginSuccess.value = false
            }
        }
    }

}