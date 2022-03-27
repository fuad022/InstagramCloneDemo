package com.example.instagramclonedemo.ui.profile.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentProfileMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProfileMenuBottomSheet : BottomSheetDialogFragment() {
    private val binding by lazy { FragmentProfileMenuBottomSheetBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}