package com.example.customer.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CustomerApiHelper {
    private const val baseUrl = "http://172.16.4.72:8089/car/"

    val api: CustomerApiService by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CustomerApiService::class.java)
    }

}