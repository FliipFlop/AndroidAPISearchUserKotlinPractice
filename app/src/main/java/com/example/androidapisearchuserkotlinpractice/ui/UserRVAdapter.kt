package com.example.androidapisearchuserkotlinpractice.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapisearchuserkotlinpractice.R
import com.example.androidapisearchuserkotlinpractice.model.UserItem
import com.example.androidapisearchuserkotlinpractice.model.UserModel
import kotlinx.android.synthetic.main.item_user.view.*

class UserRVAdapter : RecyclerView.Adapter<UserRVAdapter.ViewHolder>() {

    private var mContext: Context? = null
    private var userList: ArrayList<UserItem>? = null

    init {
        userList = ArrayList<UserItem>()
    }

    fun updateUserList(list: ArrayList<UserItem>?) {
        userList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        return ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return userList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvUserId.text = userList?.get(position)?.id
        holder.tvUsername.text = userList?.get(position)?.login
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivUserProfile = itemView.ivUserProfile
        var tvUserId = itemView.tvUserId
        var tvUsername = itemView.tvUsername
        var btnViewProfile = itemView.btnViewProfile

    }
}
