package com.example.instagramclonedemo.ui.likes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {
    private val binding by lazy { FragmentFollowingBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}