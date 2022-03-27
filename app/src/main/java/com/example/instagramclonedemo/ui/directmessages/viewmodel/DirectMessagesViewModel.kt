package com.example.instagramclonedemo.ui.directmessages.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.DirectMessagesModel
import com.example.instagramclonedemo.repository.DataRepository

class DirectMessagesViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _mockMessagesDataList = MutableLiveData<List<DirectMessagesModel>>()
    val mockMessagesDataList: LiveData<List<DirectMessagesModel>> get() = _mockMessagesDataList

    init {
        _mockMessagesDataList.value = dataRepository.getRepoMessagesList()
    }

}