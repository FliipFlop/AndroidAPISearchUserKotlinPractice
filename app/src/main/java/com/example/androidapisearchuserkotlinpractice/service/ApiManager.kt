package com.example.androidapisearchuserkotlinpractice.service

import com.example.androidapisearchuserkotlinpractice.R
import com.example.androidapisearchuserkotlinpractice.application.Contextor
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {

    private var instance: ApiManager? = null

    fun getInstance(): ApiManager {
        if (instance == null) instance = ApiManager
        return instance as ApiManager
    }

    private var mContext = Contextor.getInstance().getContext()
    private var service: ApiService? = null

    init {
        val gson = Gson()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(mContext?.getString(R.string.base_api_url))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        service = retrofit.create(ApiService::class.java)
    }

    fun getService(): ApiService? {
        return service
    }
}