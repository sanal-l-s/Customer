package com.example.customer.modules.signup.network


import com.example.customer.modules.signup.model.SignUpResponse
import com.example.customer.modules.signup.model.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
    @POST("users")
     suspend fun signUp(@Body userData : UserData):Response<SignUpResponse>
}