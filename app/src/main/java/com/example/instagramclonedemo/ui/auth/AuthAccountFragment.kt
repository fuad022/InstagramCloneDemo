package com.example.instagramclonedemo.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentAuthAccountBinding

class AuthAccountFragment : Fragment() {
    private val binding by lazy { FragmentAuthAccountBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        binding.footerTxt.text =
        init()
        return binding.root
    }

    private fun init() {
        binding.loginBtn.setOnClickListener {
            val action = AuthAccountFragmentDirections.actionAuthAccountFragmentToRootFragment()
            findNavController().navigate(action)
        }

        binding.btn.setOnClickListener {
            val action =
                AuthAccountFragmentDirections.actionAuthAccountFragmentToAuthLoginFragment()
            findNavController().navigate(action)
        }
    }
}