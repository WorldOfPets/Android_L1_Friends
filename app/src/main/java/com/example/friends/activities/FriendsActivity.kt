package com.example.friends.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.friends.R
import moxy.MvpAppCompatActivity

class FriendsActivity : MvpAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)
    }
}