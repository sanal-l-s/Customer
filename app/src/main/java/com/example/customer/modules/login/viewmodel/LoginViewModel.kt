package com.example.customer.modules.login.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customer.modules.login.model.UserData
import com.example.customer.network.CustomerApiHelper
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private var userData = MutableLiveData<UserData?>()
    private var isLoginSuccess = MutableLiveData<Boolean>()

    fun login(userName: String, userPassWord: String) {
        viewModelScope.launch {
            CustomerApiHelper.api.login(userName, userPassWord).apply {
                //set the success value to live data
                isLoginSuccess.value = isSuccessful

                //set success response to live data. otherwise null
                if (isSuccessful) {
                    //try catch to catch NoSuchElementException
                    try {

                        //taking first  element from list
                        userData.value = body()?.first() //this line causes NoSuchElementException
                    } catch (e: NoSuchElementException) {
                        e.printStackTrace()
                        Log.i("Exception", "login: $e")

                        //set userdata to null
                        userData.value = null
                    }
                } else {
                    Log.i("Exception", "login: ${errorBody().toString()}")
                }
            }
        }
    }

}