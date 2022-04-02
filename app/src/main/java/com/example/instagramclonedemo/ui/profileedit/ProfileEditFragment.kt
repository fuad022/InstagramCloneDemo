package com.example.instagramclonedemo.ui.profileedit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentProfileEditBinding
import com.example.instagramclonedemo.ui.igtv.IgtvFragmentDirections

class ProfileEditFragment : Fragment() {
    private val binding by lazy { FragmentProfileEditBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onBackPressed()
        init()
        return binding.root
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(ProfileEditFragmentDirections.actionProfileEditFragmentToProfile())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
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