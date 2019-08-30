package com.example.androidapisearchuserkotlinpractice.ui

import com.example.androidapisearchuserkotlinpractice.model.UserItem

interface IMainView {
    fun updateUserList(userList: ArrayList<UserItem>?)
    fun hideKeyboard()
}