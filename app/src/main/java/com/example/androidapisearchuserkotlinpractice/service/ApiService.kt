package com.example.androidapisearchuserkotlinpractice.service

import com.example.androidapisearchuserkotlinpractice.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun searchUser(@Query("q") q: String?): Call<UserModel>
}