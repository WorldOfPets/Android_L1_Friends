package com.example.friends.providers

import android.os.Looper
import com.example.friends.models.FriendModel
import com.example.friends.presenters.FriendsPresenter
import java.util.logging.Handler

class FriendsProvider(var presenter: FriendsPresenter) {
    fun testLoadFriends(hasFriends:Boolean){
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val friendsList: ArrayList<FriendModel> = ArrayList()
            if(hasFriends){
                val friend1 = FriendModel("Evgen", "Polivanvo", "Moscow", null, true)
                val friend2 = FriendModel("Valentina", "Sayapina", "Astrahan", null, false)
                val friend3 = FriendModel("Dmitri", "Syromytnik", null, null, true)
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)
            }else{

            }
            presenter.friendsLoaded(friendsList)
        }, 2000)
    }
}