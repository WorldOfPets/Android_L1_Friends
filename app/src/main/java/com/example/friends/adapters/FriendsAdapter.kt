package com.example.friends.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.R
import com.example.friends.databinding.CellFriendBinding
import com.example.friends.models.FriendModel


class FriendsAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mFriendsList: ArrayList<FriendModel> = ArrayList()
    private var sourceFriendsList: ArrayList<FriendModel> = ArrayList()
    fun filter(query: String) {
        mFriendsList.clear()
        sourceFriendsList.forEach {
            if(it.name.contains(query, true) || it.surname.contains(query, true)){
                mFriendsList.add(it)
            } else {
                it.city?.let { city ->
                    if(city.contains(query, true)){
                        mFriendsList.add(it)
                    }
                }
            }
        }
        notifyDataSetChanged()
    }
    fun setupFriends(friendsList: ArrayList<FriendModel>){
        sourceFriendsList.clear()
        sourceFriendsList.addAll(friendsList)
        filter("")
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        //val layoutInflater = LayoutInflater.from(p0.context)
        val bind = CellFriendBinding.inflate(LayoutInflater.from(p0.context), p0, false)
        //val itemView = layoutInflater.inflate(R.layout.cell_friend, p0, false)
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
        private var city: TextView = bind.txtCity
        private var isOnline: View = bind.viewOnline

        fun binds(friendModel: FriendModel){
            fullName.text = "${friendModel.name} ${friendModel.surname}"
            city.text = itemView.context.getString(R.string.no_city)
            friendModel.city?.let { city.text = it }
            isOnline.setBackgroundResource(R.color.light_blue)
            if (friendModel.isOnline){
                isOnline.visibility = View.VISIBLE
            }else{
                isOnline.visibility = View.GONE
            }
        }
    }
}