package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DirectMessagesModel(
    val imageProfileMessages: Int,
    val usernameMessages: String,
    val textMessages: String,
    val timeMessages: String,
) : Parcelable