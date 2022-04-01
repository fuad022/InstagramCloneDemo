package com.example.instagramclonedemo.repository

import com.example.instagramclonedemo.data.mocklist.MockData.getFollowingLikesList
import com.example.instagramclonedemo.data.mocklist.MockData.getHomePostsList
import com.example.instagramclonedemo.data.mocklist.MockData.getHomeStoriesList
import com.example.instagramclonedemo.data.mocklist.MockData.getMessagesList
import com.example.instagramclonedemo.data.mocklist.MockData.getProfilePhotosList
import com.example.instagramclonedemo.data.mocklist.MockData.getProfileStoriesList
import com.example.instagramclonedemo.data.mocklist.MockData.getSearchPhotosList
import com.example.instagramclonedemo.data.mocklist.MockData.getSearchTabsList
import com.example.instagramclonedemo.data.mocklist.MockData.getYouLikesList
import com.example.instagramclonedemo.data.model.*

class DataRepository {

    fun getRepoHomeStoriesList(): List<HomeStoriesModel> = getHomeStoriesList()
    fun getRepoHomePostsList(): List<HomePostModel> = getHomePostsList()

    fun getRepoMessagesList(): List<DirectMessagesModel> = getMessagesList()

    fun getRepoSearchTabsList(): List<SearchModel> = getSearchTabsList()
    fun getRepoSearchPhotosList(): List<SearchModel> = getSearchPhotosList()

    fun getRepoYouLikesList(): List<LikesModel> = getYouLikesList()
    fun getRepoFollowingLikesList(): List<LikesModel> = getFollowingLikesList()

    fun getRepoProfileStoriesList(): List<ProfileModel> = getProfileStoriesList()
    fun getRepoProfilePhotosList(): List<ProfileModel> = getProfilePhotosList()
}