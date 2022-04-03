package com.example.instagramclonedemo.ui.likes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.databinding.FragmentFollowingBinding
import com.example.instagramclonedemo.ui.likes.adapter.LikesAdapter
import com.example.instagramclonedemo.ui.likes.adapter.LikesNestedAdapter
import com.example.instagramclonedemo.ui.likes.viewmodel.LikesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FollowingFragment : Fragment() {
    private val binding by lazy { FragmentFollowingBinding.inflate(layoutInflater) }
    private val likesViewModel: LikesViewModel by viewModel()
//    private val likesAdapter = LikesAdapter()
    private val likesNestedAdapter = LikesNestedAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initLikes()
        return binding.root
    }

    private fun initLikes() {
        likesViewModel.mockFollowingLikesDataList.observe(viewLifecycleOwner) {
            likesNestedAdapter.submitList(it.toMutableList())
        }
        binding.followingLikesRv.adapter = likesNestedAdapter
    }
}