package com.example.androidapisearchuserkotlinpractice.ui

import android.util.Log
import com.example.androidapisearchuserkotlinpractice.model.UserModel
import com.example.androidapisearchuserkotlinpractice.service.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : IMainPresenter {

    private lateinit var view: MainFragment

    override fun attachView(view: MainFragment) {
        this.view = view
    }

    override fun loadUser(username: String?) {
        var call: Call<UserModel> =
            ApiManager.getInstance().getService()!!.searchUser(username.toString())
        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("FLIPFLOP", "fail ${t.message}")
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.isSuccessful) {
                    Log.d("FLIPFLOP", "success ${response.body()?.items?.size.toString()}")
                    view.updateUserList(response.body()?.items)
                } else
                    Log.d("FLIPFLOP", "not success ${response.errorBody().toString()}")
            }

        })
        view.hideKeyboard()
    }
}