package com.example.friends.views


import com.example.friends.models.FriendsApiModels
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView: MvpView {
    fun showError(textResource:Int)
    fun setupEmptyList()
    fun setupFriendsList(friendsList: ArrayList<FriendsApiModels>)
    fun startLoading()
    fun endLoading()
}