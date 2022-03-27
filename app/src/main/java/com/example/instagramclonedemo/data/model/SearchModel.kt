package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchModel(
    //Tabs
    val icon: Int?,
    val title: String?,
    //Photos
    val photo: Int?
) : Parcelable