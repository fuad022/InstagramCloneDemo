package com.example.instagramclonedemo.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentProfileBinding
import com.example.instagramclonedemo.ui.profile.adapter.ProfileStoriesAdapter
import com.example.instagramclonedemo.ui.profile.adapter.ViewPagerAdapter
import com.example.instagramclonedemo.ui.profile.bottomsheet.ProfileMenuBottomSheet
import com.example.instagramclonedemo.ui.profile.viewmodel.ProfileViewModel
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {
    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    private val profileViewModel: ProfileViewModel by viewModel()
    private val profileStoriesAdapter = ProfileStoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initMenuBtn()
        observeStoriesList()
        init()
        return binding.root
    }

    private fun initMenuBtn() {
        binding.menu.setOnClickListener {
            ProfileMenuBottomSheet().show(activity?.supportFragmentManager!!, "BottomSheetDialog")
        }
    }

    private fun observeStoriesList() {
        profileViewModel.mockProfileStoriesDataList.observe(viewLifecycleOwner) {
            profileStoriesAdapter.submitList(it.toMutableList())
        }
        binding.profileStoriesRv.adapter = profileStoriesAdapter
    }

    private fun init() {

        val adapter = ViewPagerAdapter(activity?.supportFragmentManager!!, lifecycle)
        binding.viewPager.adapter = adapter
        binding.viewPager.getChildAt(0)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_grid_on)
                }
                1 -> {
                    tab.setIcon(R.drawable.ic_tags_on)
                }
            }
        }.attach()

    }
}