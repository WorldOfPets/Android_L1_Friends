package com.example.friends.presenters

import android.os.Handler
import android.os.Looper
import com.example.friends.R
import com.example.friends.views.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {
    fun login(isSuccess:Boolean) {
        viewState.startLoading()
        Handler(Looper.getMainLooper()).postDelayed({
            viewState.endLoading()
            if(isSuccess){
                viewState.openFriends()
            }else{
                viewState.showError(textResource = R.string.connect_error)
            }
        }, 500)
    }
}