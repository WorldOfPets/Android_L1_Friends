package com.example.friends.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.adapters.FriendsAdapter
import com.example.friends.databinding.ActivityFriendsBinding
import com.example.friends.models.FriendsApiModels
import com.example.friends.presenters.FriendsPresenter
import com.example.friends.views.FriendsView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    private lateinit var bind: ActivityFriendsBinding
    private lateinit var adapter: FriendsAdapter
    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(bind.root)

        friendsPresenter.loadFriends()

        bind.editSerarch.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
                adapter.filter(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        adapter = FriendsAdapter()
        bind.recyclerFriends.adapter = adapter
        bind.recyclerFriends.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        bind.recyclerFriends.setHasFixedSize(true)
    }

    override fun showError(textResource: Int) {
        bind.textNoitems.text = getString(textResource)
    }

    override fun setupEmptyList() {
        bind.recyclerFriends.visibility = View.GONE
        bind.textNoitems.visibility = View.VISIBLE
    }

    override fun setupFriendsList(friendsList: ArrayList<FriendsApiModels>) {
        bind.recyclerFriends.visibility = View.VISIBLE
        bind.textNoitems.visibility = View.GONE

        adapter.setupFriends(friendsList)
    }

    override fun startLoading() {
        bind.recyclerFriends.visibility = View.GONE
        bind.textNoitems.visibility = View.GONE
        bind.cpvFriends.visibility = View.VISIBLE
    }

    override fun endLoading() {
        bind.cpvFriends.visibility = View.GONE
    }
}