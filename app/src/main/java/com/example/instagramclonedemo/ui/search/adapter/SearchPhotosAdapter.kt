package com.example.instagramclonedemo.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.SearchModel
import com.example.instagramclonedemo.databinding.PhotosRvItemBinding

class SearchPhotosAdapter : ListAdapter<SearchModel, SearchPhotosAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: PhotosRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SearchModel) {
            binding.img.setImageResource(model.photo!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            PhotosRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<SearchModel>() {
        override fun areItemsTheSame(
            oldItem: SearchModel,
            newItem: SearchModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: SearchModel,
            newItem: SearchModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<SearchModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}