package com.example.friends.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.R
import com.example.friends.models.FriendModel


class FriendsAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFriendsList: ArrayList<FriendModel> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val itemView = layoutInflater.inflate(R.layout.cell_friend, p0, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

    }

    class FriendsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}