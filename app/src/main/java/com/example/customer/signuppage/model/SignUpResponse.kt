package com.example.customer.signuppage.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("userMail") val email: String,
    @SerializedName("userName") val name: String,
    @SerializedName("errorCode") val errorCode :String,
    @SerializedName("errorMessage") val errorMessage : String
)

