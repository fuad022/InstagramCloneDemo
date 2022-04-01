package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomePostModel(
    val imageProfilePost: Int,
    val usernamePost: String,
    val locationPost: String,
    val imagePost: Int,
    val imageLiker: Int,
    val likedCountPost: String,
    val commentPost: String
) : Parcelable