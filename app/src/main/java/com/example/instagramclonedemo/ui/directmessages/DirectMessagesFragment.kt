package com.example.instagramclonedemo.ui.directmessages

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.data.model.DirectMessagesModel
import com.example.instagramclonedemo.databinding.FragmentDirectMessagesBinding
import com.example.instagramclonedemo.ui.directmessages.adapter.DirectMessagesAdapter
import com.example.instagramclonedemo.ui.directmessages.viewmodel.DirectMessagesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DirectMessagesFragment : Fragment() {
    private val binding by lazy { FragmentDirectMessagesBinding.inflate(layoutInflater) }
    private val directMessagesViewModel: DirectMessagesViewModel by viewModel()
    private val directMessagesAdapter = DirectMessagesAdapter()
    private val messagesList = arrayListOf<DirectMessagesModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.search.setupClearButtonWithAction()
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


    @SuppressLint("ClickableViewAccessibility")
    fun EditText.setupClearButtonWithAction() {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(ed: Editable?) {
                filter(ed.toString())
                val clearIcon = if (ed?.isNotEmpty() == true) R.drawable.ic_clear else 0
                setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_search, 0, clearIcon, 0)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        })

        setOnTouchListener(View.OnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (this.right - this.compoundPaddingRight)) {
                    this.setText("")
                    return@OnTouchListener true
                }
            }
            return@OnTouchListener false
        })
    }


    private fun filter(text: String) {
        val filteredMessagesList = arrayListOf<DirectMessagesModel>()
        messagesList.forEach {
            if (text.lowercase() in it.usernameMessages.lowercase())
                filteredMessagesList.add(it)
            directMessagesAdapter.submitList(filteredMessagesList.toMutableList())
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
            messagesList.addAll(it)
            directMessagesAdapter.submitList(it.toMutableList())
        }
        binding.messagesRv.adapter = directMessagesAdapter
    }

}