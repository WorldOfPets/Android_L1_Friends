package com.example.friends.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.friends.databinding.ActivityLoginBinding
import com.example.friends.presenters.LoginPresenter
import com.example.friends.views.LoginView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView  {
    private lateinit var bind: ActivityLoginBinding

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnLogin.setOnClickListener {
            loginPresenter.login(isSuccess = true)
        }
    }

    override fun startLoading() {
        bind.btnLogin.visibility = View.GONE
        bind.cpvLoader.visibility = View.VISIBLE
    }

    override fun endLoading() {
        bind.btnLogin.visibility = View.VISIBLE
        bind.cpvLoader.visibility = View.GONE
    }

    override fun showError(textResource: Int) {
        Toast.makeText(applicationContext, getString(textResource), Toast.LENGTH_LONG).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }
}