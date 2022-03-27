package com.example.instagramclonedemo.ui.likes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagramclonedemo.data.model.LikesModel
import com.example.instagramclonedemo.repository.DataRepository

class LikesViewModel(private val dataRepository: DataRepository) : ViewModel() {

    private val _mockNewLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockNewLikesDataList: LiveData<List<LikesModel>> get() = _mockNewLikesDataList

    init {
        _mockNewLikesDataList.value = dataRepository.getRepoLikesNewList()
    }

    private val _mockTodayLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockTodayLikesDataList: LiveData<List<LikesModel>> get() = _mockTodayLikesDataList

    init {
        _mockTodayLikesDataList.value = dataRepository.getRepoLikesTodayList()
    }

    private val _mockThisWeekLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockThisWeekLikesDataList: LiveData<List<LikesModel>> get() = _mockThisWeekLikesDataList

    init {
        _mockThisWeekLikesDataList.value = dataRepository.getRepoLikesThisWeekList()
    }

    private val _mockThisMonthLikesDataList = MutableLiveData<List<LikesModel>>()
    val mockThisMonthLikesDataList: LiveData<List<LikesModel>> get() = _mockThisMonthLikesDataList

    init {
        _mockThisMonthLikesDataList.value = dataRepository.getRepoLikesThisMonthList()
    }

}