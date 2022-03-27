package com.example.instagramclonedemo.ui.likes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentLikesBinding
import com.example.instagramclonedemo.ui.likes.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LikesFragment : Fragment() {
    private val binding by lazy { FragmentLikesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        return binding.root
    }

    private fun init() {

        val adapter = ViewPagerAdapter(activity?.supportFragmentManager!!, lifecycle)
        binding.viewPager.adapter = adapter
        binding.viewPager.getChildAt(0)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Following"
                }
                1 -> {
                    tab.text = "You"
                }
            }
        }.attach()

    }
}