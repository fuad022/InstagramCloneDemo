package com.example.instagramclonedemo.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentProfileBinding
import com.example.instagramclonedemo.root.RootFragment
import com.example.instagramclonedemo.ui.profile.adapter.ProfileStoriesAdapter
import com.example.instagramclonedemo.ui.profile.adapter.ViewPagerAdapter
import com.example.instagramclonedemo.ui.profile.viewmodel.ProfileViewModel
import com.example.instagramclonedemo.util.Util
import com.example.instagramclonedemo.util.Util.backPressed
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
        backPressed(requireActivity())
        initMenuBtn()
        initEditBtn()
        observeStoriesList()
        init()
        return binding.root
    }

    private fun initEditBtn() {
        binding.editBtn.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileToProfileEditFragment()
            findNavController().navigate(action)
        }
    }

    private fun initMenuBtn() {
        val navHostFragment = parentFragment as NavHostFragment
        val rootFragment = navHostFragment.parentFragment as RootFragment
        binding.menu.setOnClickListener {
            if (rootFragment.getDrawerLayout().isDrawerOpen(GravityCompat.END))
                rootFragment.getDrawerLayout().closeDrawer(GravityCompat.END)
            rootFragment.getDrawerLayout().openDrawer(GravityCompat.END)
            setupDrawerAnimation()
        }
    }

    private fun setupDrawerAnimation() {
        val navHostFragment = parentFragment as NavHostFragment
        val rootFragment = navHostFragment.parentFragment as RootFragment
        rootFragment.getDrawerLayout().apply {
            elevation = 0f
            setScrimColor(Color.TRANSPARENT)
            addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    val slideX = drawerView.width * slideOffset
                    binding.constraint.translationX = -slideX
                    rootFragment.getBottomNav().translationX = -slideX
                }
            }
            )
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