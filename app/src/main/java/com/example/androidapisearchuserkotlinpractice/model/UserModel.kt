package com.example.androidapisearchuserkotlinpractice.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("total_count")
    var totalCount: Int,
    @SerializedName("incomplete_results")
    var incompleteResults: Boolean,
    @SerializedName("items")
    var items: ArrayList<UserItem>? = null
)