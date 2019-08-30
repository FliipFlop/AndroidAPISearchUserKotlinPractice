package com.example.androidapisearchuserkotlinpractice.ui


interface IMainPresenter {
    fun attachView(view : MainFragment)
    fun loadUser(username:String?)
}