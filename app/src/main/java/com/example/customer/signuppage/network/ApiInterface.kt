package com.example.customer.signuppage.network


import com.example.customer.signuppage.model.SignUpResponse
import com.example.customer.signuppage.model.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
    @POST("users")
     suspend fun signUp(@Body userData : UserData):Response<SignUpResponse>
}