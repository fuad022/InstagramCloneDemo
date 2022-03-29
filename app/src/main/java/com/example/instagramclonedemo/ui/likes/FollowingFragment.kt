package com.example.instagramclonedemo.ui.likes

import android.os.Bundle
import android.util.Log
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
    private val likesAdapter1 = LikesAdapter()
    private val likesAdapter2 = LikesAdapter()
    private val likesAdapter3 = LikesAdapter()
    private val likesAdapter4 = LikesAdapter()

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
            likesAdapter1.submitList(it.toMutableList())
            Log.d("initNewLikes", it.toString())
        }
        binding.newRv.adapter = likesAdapter1
    }

    private fun initTodayLikes() {
        likesViewModel.mockTodayLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter2.submitList(it.toMutableList())
            Log.d("initTodayLikes", it.toString())
        }
        binding.todayRv.adapter = likesAdapter2
    }

    private fun initThisWeekLikes() {
        likesViewModel.mockThisWeekLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter3.submitList(it.toMutableList())
            Log.d("initThisWeekLikes", it.toString())
        }
        binding.thisWeekRv.adapter = likesAdapter3
    }

    private fun initThisMonthLikes() {
        likesViewModel.mockThisMonthLikesDataList.observe(viewLifecycleOwner) {
            likesAdapter4.submitList(it.toMutableList())
            Log.d("initThisMonthLikes", it.toString())
        }
        binding.thisMonthRv.adapter = likesAdapter4
    }

}