package com.example.instagramclonedemo.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentAuthAccountBinding

class AuthAccountFragment : Fragment() {
    private val binding by lazy { FragmentAuthAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // init()
        return binding.root
    }

}