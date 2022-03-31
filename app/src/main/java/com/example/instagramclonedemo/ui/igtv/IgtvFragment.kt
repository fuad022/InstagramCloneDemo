package com.example.instagramclonedemo.ui.igtv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentIgtvBinding

class IgtvFragment : Fragment() {
    private val binding by lazy { FragmentIgtvBinding.inflate(layoutInflater) }
//    private val args: IgtvFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}