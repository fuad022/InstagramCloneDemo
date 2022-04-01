package com.example.instagramclonedemo.ui.likes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.LikesModel
import com.example.instagramclonedemo.repository.DataRepository

class LikesViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _mockYouLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockYouLikesDataList: LiveData<List<LikesModel>> get() = _mockYouLikesDataList

    init {
        _mockYouLikesDataList.value = dataRepository.getRepoYouLikesList()
    }

    private val _mockFollowingLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockFollowingLikesDataList: LiveData<List<LikesModel>> get() = _mockFollowingLikesDataList

    init {
        _mockFollowingLikesDataList.value = dataRepository.getRepoFollowingLikesList()
    }
}