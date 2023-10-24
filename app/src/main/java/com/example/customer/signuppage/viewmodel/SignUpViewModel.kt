package com.example.customer.signuppage.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.customer.signuppage.network.ApiInterface
import com.example.customer.signuppage.network.RetrofitHelper
import com.example.customer.signuppage.model.SignUpResponse
import com.example.customer.signuppage.model.UserData
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.lang.Exception

class SignUpViewModel : ViewModel(){
    var signup:MutableLiveData<SignUpResponse> = MutableLiveData()

            fun fetchSignup(userData: UserData){
                viewModelScope.launch {
                    try {
                        val retrofit = RetrofitHelper.getInstance()
                        val service = retrofit.create(ApiInterface::class.java)
                        val response = service.signUp(userData)
                        signup.value=response.body()
                        if (response.isSuccessful) {

                            Log.d("RESPONSE", "Success - Status Code: ${response.code()}")
                        } else {
                            val errorBody = response.errorBody()
                            if (errorBody != null) {
                                val errorResponse = Gson().fromJson(errorBody.string(), SignUpResponse::class.java)
                                val errorMessage = errorResponse.errorMessage
                                Log.d("RESPONSE", "Error - Status Code: ${response.code()}, Error Message: $errorMessage")
                            }

                        }


                    }catch (e:Exception){

                        Log.d("VIEW MODEL ERROR",e.message.toString())
                    }
                }
            }
}