package com.example.instagramclonedemo.ui.profileedit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentProfileEditBinding

class ProfileEditFragment : Fragment() {
    private val binding by lazy { FragmentProfileEditBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        init()
        return binding.root
    }

    private fun init() {
        binding.cancel.setOnClickListener {
            val action = ProfileEditFragmentDirections.actionProfileEditFragmentToProfile()
            findNavController().navigate(action)
        }

        binding.done.setOnClickListener {
            val action = ProfileEditFragmentDirections.actionProfileEditFragmentToProfile()
            findNavController().navigate(action)
        }
    }
}