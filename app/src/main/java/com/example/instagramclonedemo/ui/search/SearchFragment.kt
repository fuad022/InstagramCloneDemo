package com.example.instagramclonedemo.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instagramclonedemo.databinding.FragmentSearchBinding
import com.example.instagramclonedemo.ui.search.adapter.SearchPhotosAdapter
import com.example.instagramclonedemo.ui.search.adapter.SearchTabsAdapter
import com.example.instagramclonedemo.ui.search.viewmodel.SearchViewModel
import com.example.instagramclonedemo.util.SpannedGridLayoutManager
import com.example.instagramclonedemo.util.Util
import com.example.instagramclonedemo.util.Util.backPressed
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private val searchViewModel: SearchViewModel by viewModel()
    private val searchTabsAdapter = SearchTabsAdapter()
    private val searchPhotosAdapter = SearchPhotosAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        backPressed(requireActivity())
        hideSoftKeyboard()
        setupTabAdapter()
        observePhotosList()
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun hideSoftKeyboard() {
        binding.photosRv.setOnTouchListener { view, motionEvent ->
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
    }

    private fun setupTabAdapter() {
        searchTabsAdapter.setOnClickListener { model ->
            model.let {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchToIgtvFragment(model)
                )
            }
        }
        observeTabsList()
    }

    private fun observeTabsList() {
        searchViewModel.mockTabsDataList.observe(viewLifecycleOwner) {
            searchTabsAdapter.submitList(it.toMutableList())
        }
        binding.tabsRv.adapter = searchTabsAdapter
    }

    private fun observePhotosList() {
        searchViewModel.mockPhotosDataList.observe(viewLifecycleOwner) {
            searchPhotosAdapter.submitList(it.toMutableList())
            val params: ViewGroup.LayoutParams = binding.photosRv.getLayoutParams()
            params.height = 180 * it.size
            binding.photosRv.layoutParams = params

        }

        val manager = SpannedGridLayoutManager(
            object : SpannedGridLayoutManager.GridSpanLookup {
                override fun getSpanInfo(position: Int): SpannedGridLayoutManager.SpanInfo {
                    return if (position % 12 == 1 || position % 12 == 6) {
                        SpannedGridLayoutManager.SpanInfo(2, 2)
                    } else {
                        SpannedGridLayoutManager.SpanInfo(1, 1)
                    }
                }
            },
            3,
            1f
        )

        binding.photosRv.layoutManager = manager
        binding.photosRv.adapter = searchPhotosAdapter
    }
}