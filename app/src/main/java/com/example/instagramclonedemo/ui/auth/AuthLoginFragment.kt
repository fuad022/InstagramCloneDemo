package com.example.instagramclonedemo.ui.auth

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.navigation.fragment.findNavController
import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.databinding.FragmentAuthLoginBinding

class AuthLoginFragment : Fragment(), TextWatcher {
    private val binding by lazy { FragmentAuthLoginBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initToolbar()
        init()
        return binding.root
    }

    private fun initToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
    }

    private fun init() {
        binding.loginBtn.isEnabled = false
        binding.login.addTextChangedListener(this)
        binding.password.addTextChangedListener(this)

        binding.loginBtn.setOnClickListener {
            val action = AuthLoginFragmentDirections.actionAuthLoginFragmentToRootFragment()
            findNavController().navigate(action)
        }
    }

    override fun afterTextChanged(s: Editable?) {
        binding.loginBtn.isEnabled =
            binding.login.text.toString().isNotEmpty() &&
                    binding.password.text.toString().isNotEmpty()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
}