package com.example.instagramclonedemo.ui.likes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.LikesModel
import com.example.instagramclonedemo.repository.DataRepository

class LikesViewModel(private val dataRepository: DataRepository) : ViewModel() {
    private val _mockLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockLikesDataList: LiveData<List<LikesModel>> get() = _mockLikesDataList

    init {
        _mockLikesDataList.value = dataRepository.getRepoLikesList()
    }
}