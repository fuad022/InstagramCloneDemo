package com.example.instagramclonedemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentHomeBinding
import com.example.instagramclonedemo.ui.home.adapter.HomePostAdapter
import com.example.instagramclonedemo.ui.home.adapter.HomeStoriesAdapter
import com.example.instagramclonedemo.ui.home.viewmodel.HomeViewModel
import com.example.instagramclonedemo.util.Util
import com.example.instagramclonedemo.util.Util.backPressed
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val homeViewModel: HomeViewModel by viewModel()
    private val homeStoriesAdapter = HomeStoriesAdapter()
    private val homePostAdapter = HomePostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        backPressed(requireActivity())
        initMessageBtn()
        observeStoriesList()
        observePostsList()
        return binding.root
    }

    private fun initMessageBtn() {
        binding.message.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToDirectMessagesFragment()
            findNavController().navigate(action)
        }
    }

    private fun observeStoriesList() {
        homeViewModel.mockStoriesDataList.observe(viewLifecycleOwner) {
            homeStoriesAdapter.submitList(it.toMutableList())
        }
        binding.storiesRv.adapter = homeStoriesAdapter
    }

    private fun observePostsList() {
        homeViewModel.mockPostsDataList.observe(viewLifecycleOwner) {
            homePostAdapter.submitList(it.toMutableList())
        }
        binding.postRv.adapter = homePostAdapter
    }
}