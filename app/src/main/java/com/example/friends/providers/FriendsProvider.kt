package com.example.friends.providers

import android.os.Handler
import android.os.Looper
import android.os.StrictMode
import android.util.Log

import com.example.friends.models.FriendsApiModels
import com.example.friends.presenters.FriendsPresenter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.*


class FriendsProvider(var presenter: FriendsPresenter) {
    private val TAG: String = FriendsProvider::class.java.simpleName

    fun loadFriends(){
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/users")
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: java.io.IOException) {
                Log.e(TAG, e.message.toString())
                presenter.friendsLoaded(arrayListOf())
            }
            var mainHandler = Handler(Looper.getMainLooper())
            override fun onResponse(call: Call, response: Response) {
                mainHandler.post{
                    val gson = GsonBuilder().serializeNulls().create()
                    val itemType = object : TypeToken<ArrayList<FriendsApiModels>>() {}.type
                    val itemsList = gson.fromJson<ArrayList<FriendsApiModels>>(response.body!!.string(), itemType)

                    presenter.friendsLoaded(itemsList)
                }
            }
        })
    }
}