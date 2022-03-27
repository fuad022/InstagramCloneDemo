package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileModel(
    val image: Int,
    val profileStoriesName: String?
) : Parcelable