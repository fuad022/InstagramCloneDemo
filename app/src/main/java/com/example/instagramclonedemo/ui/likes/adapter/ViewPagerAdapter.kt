package com.example.instagramclonedemo.ui.likes.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagramclonedemo.ui.likes.FollowingFragment
import com.example.instagramclonedemo.ui.likes.YouFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FollowingFragment()
            }
            1 -> {
                YouFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}