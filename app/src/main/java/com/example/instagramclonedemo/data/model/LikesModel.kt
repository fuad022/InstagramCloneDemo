package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LikesModel(
    val ownerImg: Int,
    val eventTxt: String,
    val image: Int?
) : Parcelable