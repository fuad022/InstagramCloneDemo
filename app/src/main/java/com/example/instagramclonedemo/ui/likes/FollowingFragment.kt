package com.example.instagramclonedemo.ui.likes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.databinding.FragmentFollowingBinding
import com.example.instagramclonedemo.ui.likes.adapter.LikesAdapter
import com.example.instagramclonedemo.ui.likes.viewmodel.LikesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FollowingFragment : Fragment() {
    private val binding by lazy { FragmentFollowingBinding.inflate(layoutInflater) }
    private val likesViewModel: LikesViewModel by viewModel()
    private val likesAdapter = LikesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initNewLikes()
        initTodayLikes()
        initThisWeekLikes()
        initThisMonthLikes()
        return binding.root
    }

    private fun initNewLikes() {
        likesViewModel.mockNewLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter.submitList(it.toMutableList())
        }
        binding.newRv.adapter = likesAdapter
    }

    private fun initTodayLikes() {
        likesViewModel.mockTodayLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter.submitList(it.toMutableList())
        }
        binding.todayRv.adapter = likesAdapter
    }

    private fun initThisWeekLikes() {
        likesViewModel.mockThisWeekLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter.submitList(it.toMutableList())
        }
        binding.thisWeekRv.adapter = likesAdapter
    }

    private fun initThisMonthLikes() {
        likesViewModel.mockThisMonthLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter.submitList(it.toMutableList())
        }
        binding.thisMonthRv.adapter = likesAdapter
    }

}