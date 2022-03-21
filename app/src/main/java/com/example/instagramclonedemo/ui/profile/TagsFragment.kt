package com.example.instagramclonedemo.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentTagsBinding

class TagsFragment : Fragment() {
    private val binding by lazy { FragmentTagsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // init()
        return binding.root
    }

    /*
        private fun init() {
        viewModel.mockDataList.observe(viewLifecycleOwner) {
            notificationAdapter.submitList(it.toMutableList())
        }
        binding.followingRv.adapter = notificationAdapter
    }
     */
}