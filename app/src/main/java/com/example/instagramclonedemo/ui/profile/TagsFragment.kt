package com.example.instagramclonedemo.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.databinding.FragmentTagsBinding
import com.example.instagramclonedemo.ui.profile.adapter.ProfileAdapter
import com.example.instagramclonedemo.ui.profile.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagsFragment : Fragment() {
    private val binding by lazy { FragmentTagsBinding.inflate(layoutInflater) }
    private val profileViewModel: ProfileViewModel by viewModel()
    private val profileAdapter = ProfileAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        return binding.root
    }

    private fun init() {
        profileViewModel.mockProfilePhotosDataList.observe(viewLifecycleOwner) {
            profileAdapter.submitList(it.toMutableList())
        }
        binding.tagsRv.adapter = profileAdapter
    }
}