package com.example.androidapisearchuserkotlinpractice.model

import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("url") val url: String
)