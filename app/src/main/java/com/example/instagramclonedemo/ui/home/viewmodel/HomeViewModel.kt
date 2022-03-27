package com.example.instagramclonedemo.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.HomePostModel
import com.example.instagramclonedemo.data.model.HomeStoriesModel
import com.example.instagramclonedemo.repository.DataRepository

class HomeViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _mockStoriesDataList = MutableLiveData<List<HomeStoriesModel>>()
    val mockStoriesDataList: LiveData<List<HomeStoriesModel>> get() = _mockStoriesDataList

    init {
        _mockStoriesDataList.value = dataRepository.getRepoHomeStoriesList()
    }

    private val _mockPostsDataList = MutableLiveData<List<HomePostModel>>()
    val mockPostsDataList: LiveData<List<HomePostModel>> get() = _mockPostsDataList

    init {
        _mockPostsDataList.value = dataRepository.getRepoHomePostsList()
    }
}