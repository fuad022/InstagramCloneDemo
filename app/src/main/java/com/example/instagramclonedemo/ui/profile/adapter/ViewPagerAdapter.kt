package com.example.instagramclonedemo.ui.profile.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.instagramclonedemo.ui.profile.GridFragment
import com.example.instagramclonedemo.ui.profile.TagsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                TagsFragment()
            }
            1 -> {
                GridFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}