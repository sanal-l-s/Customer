package com.example.customer.signuppage.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val BASEURL:String = "http://172.16.4.72:8089/car/"

    fun getInstance():Retrofit{
        return  Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}