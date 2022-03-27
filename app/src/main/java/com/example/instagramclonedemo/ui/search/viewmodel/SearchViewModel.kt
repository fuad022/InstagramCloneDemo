package com.example.instagramclonedemo.ui.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.SearchModel
import com.example.instagramclonedemo.repository.DataRepository

class SearchViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _mockTabsDataList = MutableLiveData<List<SearchModel>>()
    val mockTabsDataList: LiveData<List<SearchModel>> get() = _mockTabsDataList

    init {
        _mockTabsDataList.value = dataRepository.getRepoSearchTabsList()
    }

    private val _mockPhotosDataList = MutableLiveData<List<SearchModel>>()
    val mockPhotosDataList: LiveData<List<SearchModel>> get() = _mockPhotosDataList

    init {
        _mockPhotosDataList.value = dataRepository.getRepoSearchPhotosList()
    }
}