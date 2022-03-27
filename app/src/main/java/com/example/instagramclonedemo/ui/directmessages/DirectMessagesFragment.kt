package com.example.instagramclonedemo.ui.directmessages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.databinding.FragmentDirectMessagesBinding
import com.example.instagramclonedemo.ui.directmessages.adapter.DirectMessagesAdapter
import com.example.instagramclonedemo.ui.directmessages.viewmodel.DirectMessagesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DirectMessagesFragment : Fragment() {
    private val binding by lazy { FragmentDirectMessagesBinding.inflate(layoutInflater) }
    private val directMessagesViewModel: DirectMessagesViewModel by viewModel()
    private val directMessagesAdapter = DirectMessagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        observeMessageList()
        return binding.root
    }

    private fun observeMessageList() {
        directMessagesViewModel.mockMessagesDataList.observe(viewLifecycleOwner) {
            directMessagesAdapter.submitList(it.toMutableList())
        }
        binding.messagesRv.adapter = directMessagesAdapter
    }

}