package com.example.customer.network

import com.example.customer.modules.login.model.UserData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomerApiService {
    @GET("users")
    suspend fun login(
        @Query("userName") userName: String,
        @Query("userPassword") userPassword: String
    ): Response<List<UserData>>
}