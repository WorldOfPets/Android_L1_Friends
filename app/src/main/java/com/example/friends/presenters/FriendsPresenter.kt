package com.example.friends.presenters


import com.example.friends.R
import com.example.friends.models.FriendsApiModels
import com.example.friends.providers.FriendsProvider
import com.example.friends.views.FriendsView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FriendsPresenter: MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).loadFriends()
    }


    fun friendsLoaded(friendsList: ArrayList<FriendsApiModels>){
        viewState.endLoading()
        if(friendsList.size == 0){
            viewState.setupEmptyList()
            viewState.showError(textResource = R.string.friends_noitems)
        } else{
            viewState.setupFriendsList(friendsList = friendsList)
        }
    }
}