package com.example.instagramclonedemo.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LikesModel(
    val dayMonth: String?,
    val list: List<LikesNestedModel>?
) : Parcelable