package com.example.instagramclonedemo.ui.directmessages

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
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
        hideSoftKeyboard()
        initBackBtn()
        observeMessageList()
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun hideSoftKeyboard() {
        binding.messagesRv.setOnTouchListener { view, motionEvent ->
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
    }

    private fun initBackBtn() {
        binding.back.setOnClickListener {
            val action = DirectMessagesFragmentDirections.actionDirectMessagesFragmentToHome()
            findNavController().navigate(action)
        }
    }

    private fun observeMessageList() {
        directMessagesViewModel.mockMessagesDataList.observe(viewLifecycleOwner) {
            directMessagesAdapter.submitList(it.toMutableList())
        }
        binding.messagesRv.adapter = directMessagesAdapter
    }

}