package com.example.instagramclonedemo.di

import com.example.instagramclonedemo.repository.DataRepository
import com.example.instagramclonedemo.ui.directmessages.viewmodel.DirectMessagesViewModel
import com.example.instagramclonedemo.ui.home.viewmodel.HomeViewModel
import com.example.instagramclonedemo.ui.likes.viewmodel.LikesViewModel
import com.example.instagramclonedemo.ui.profile.viewmodel.ProfileViewModel
import com.example.instagramclonedemo.ui.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { DataRepository() }

    viewModel { HomeViewModel(get()) }
    viewModel { DirectMessagesViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { LikesViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
}