package com.example.customer.modules.login.model

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("userId")
    val userId: String? = null,
    @SerializedName("userName")
    val userName: String? = null,
    @SerializedName("userPhone")
    val userPhone: String? = null,
    @SerializedName("userMail")
    val userMail: String? = null,
)