package com.example.androidapisearchuserkotlinpractice.template

import com.example.androidapisearchuserkotlinpractice.application.Contextor

object SingletonTemplate {

    private var instance: SingletonTemplate? = null

    fun getInstance() : SingletonTemplate {
        if (instance == null) instance = SingletonTemplate
        return instance as SingletonTemplate
    }

    private var mContext = Contextor.getInstance().getContext()

}