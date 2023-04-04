package com.example.friends.views


import com.example.friends.models.FriendModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView: MvpView {
    fun showError(textResource:Int)
    fun setupEmptyList()
    fun setupFriendsList(friendsList: ArrayList<FriendModel>)
    fun startLoading()
    fun endLoading()
}