package com.example.instagramclonedemo.ui.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.ProfileModel
import com.example.instagramclonedemo.repository.DataRepository

class ProfileViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _mockProfileStoriesDataList = MutableLiveData<List<ProfileModel>>()
    val mockProfileStoriesDataList: LiveData<List<ProfileModel>> get() = _mockProfileStoriesDataList

    init {
        _mockProfileStoriesDataList.value = dataRepository.getRepoProfileStoriesList()
    }

    private val _mockProfilePhotosDataList = MutableLiveData<List<ProfileModel>>()
    val mockProfilePhotosDataList: LiveData<List<ProfileModel>> get() = _mockProfilePhotosDataList

    init {
        _mockProfilePhotosDataList.value = dataRepository.getRepoProfilePhotosList()
    }

}