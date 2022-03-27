package com.example.instagramclonedemo.repository

import com.example.instagramclonedemo.data.mocklist.MockData.getHomePostsList
import com.example.instagramclonedemo.data.mocklist.MockData.getHomeStoriesList
import com.example.instagramclonedemo.data.mocklist.MockData.getLikesNewList
import com.example.instagramclonedemo.data.mocklist.MockData.getLikesThisMonthList
import com.example.instagramclonedemo.data.mocklist.MockData.getLikesThisWeekList
import com.example.instagramclonedemo.data.mocklist.MockData.getLikesTodayList
import com.example.instagramclonedemo.data.mocklist.MockData.getMessagesList
import com.example.instagramclonedemo.data.mocklist.MockData.getProfilePhotosList
import com.example.instagramclonedemo.data.mocklist.MockData.getProfileStoriesList
import com.example.instagramclonedemo.data.mocklist.MockData.getSearchPhotosList
import com.example.instagramclonedemo.data.mocklist.MockData.getSearchTabsList
import com.example.instagramclonedemo.data.model.*

class DataRepository {

    fun getRepoHomeStoriesList(): List<HomeStoriesModel> = getHomeStoriesList()
    fun getRepoHomePostsList(): List<HomePostModel> = getHomePostsList()

    fun getRepoMessagesList(): List<DirectMessagesModel> = getMessagesList()

    fun getRepoSearchTabsList(): List<SearchModel> = getSearchTabsList()
    fun getRepoSearchPhotosList(): List<SearchModel> = getSearchPhotosList()

    fun getRepoLikesNewList(): List<LikesModel> = getLikesNewList()
    fun getRepoLikesTodayList(): List<LikesModel> = getLikesTodayList()
    fun getRepoLikesThisWeekList(): List<LikesModel> = getLikesThisWeekList()
    fun getRepoLikesThisMonthList(): List<LikesModel> = getLikesThisMonthList()

    fun getRepoProfileStoriesList(): List<ProfileModel> = getProfileStoriesList()
    fun getRepoProfilePhotosList(): List<ProfileModel> = getProfilePhotosList()
}