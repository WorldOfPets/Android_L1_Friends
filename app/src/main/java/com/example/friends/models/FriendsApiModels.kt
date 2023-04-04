package com.example.friends.models

import com.google.gson.annotations.SerializedName

data class FriendsApiModels(
    @SerializedName("id")
    var id: Int,
    var name: String,
    var username: String,
    var email: String,
    var phone: String,
    var website: String,
//    @Transient
//    var company: String,
//    @Expose(deserialize = false, serialize = false)
//    var customFiled: String
)
