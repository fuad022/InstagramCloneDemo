package com.example.instagramclonedemo.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instagramclonedemo.databinding.FragmentSearchBinding
import com.example.instagramclonedemo.ui.search.adapter.SearchPhotosAdapter
import com.example.instagramclonedemo.ui.search.adapter.SearchTabsAdapter
import com.example.instagramclonedemo.ui.search.viewmodel.SearchViewModel
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
        observeTabsList()
        observePhotosList()
        return binding.root
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
        }
        binding.photosRv.adapter = searchPhotosAdapter
    }
}