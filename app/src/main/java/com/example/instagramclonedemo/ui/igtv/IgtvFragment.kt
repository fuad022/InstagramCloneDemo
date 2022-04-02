package com.example.instagramclonedemo.ui.igtv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentIgtvBinding
import com.example.instagramclonedemo.util.Util.backPressed

class IgtvFragment : Fragment() {
    private val binding by lazy { FragmentIgtvBinding.inflate(layoutInflater) }
    private val args: IgtvFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        onBackPressed()
        binding.igtvImg.setImageResource(args.searchModel.photo!!)
        return binding.root
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(IgtvFragmentDirections.actionIgtvFragmentToSearch())
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }
}