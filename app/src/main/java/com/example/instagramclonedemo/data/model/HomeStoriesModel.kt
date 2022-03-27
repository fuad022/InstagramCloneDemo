package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStoriesModel(
    val imageStories: Int,
    val usernameStories: String
) : Parcelable