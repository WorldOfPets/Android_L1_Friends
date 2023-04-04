package com.example.friends.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.R
import com.example.friends.databinding.CellFriendBinding
import com.example.friends.models.FriendsApiModels


class FriendsAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFriendsList: ArrayList<FriendsApiModels> = ArrayList()
    private var sourceFriendsList: ArrayList<FriendsApiModels> = ArrayList()
    fun filter(query: String) {
        mFriendsList.clear()
        sourceFriendsList.forEach {
            if(it.name.contains(query, true) || it.username.contains(query, true)){
                mFriendsList.add(it)
            }
        }
        notifyDataSetChanged()
    }
    fun setupFriends(friendsList: ArrayList<FriendsApiModels>){
        sourceFriendsList.clear()
        sourceFriendsList.addAll(friendsList)
        filter("")
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val bind = CellFriendBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        return FriendsViewHolder( bind)
    }

    override fun getItemCount(): Int {
        return mFriendsList.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        if(p0 is FriendsViewHolder){
            p0.binds(mFriendsList[p1])
        }
    }

    class FriendsViewHolder(bind: CellFriendBinding):RecyclerView.ViewHolder(bind.root){
        private var avatar: ImageView = bind.imgAvatar
        private var fullName: TextView = bind.txtFullname
        private var username: TextView = bind.txtUsername
        private var phone: TextView = bind.txtPhone
        private var itemRecyler: LinearLayout = bind.itemRecycler

        @SuppressLint("SetTextI18n")
        fun binds(friendModel: FriendsApiModels){
            fullName.text = "Name: ${friendModel.name}"
            username.text = "Login: ${friendModel.username}"
            phone.text = "Phone: ${friendModel.phone}"
            avatar.setImageResource(R.mipmap.ic_launcher_round)
            itemRecyler.setOnClickListener {
                Toast.makeText(it.context, "Hi, my email: ${friendModel.email}", Toast.LENGTH_LONG).show()
            }
        }
    }
}