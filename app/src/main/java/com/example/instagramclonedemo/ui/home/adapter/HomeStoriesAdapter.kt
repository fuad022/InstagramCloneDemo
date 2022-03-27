package com.example.instagramclonedemo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.HomeStoriesModel
import com.example.instagramclonedemo.databinding.HomeStoriesRvItemBinding

class HomeStoriesAdapter : ListAdapter<HomeStoriesModel, HomeStoriesAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: HomeStoriesRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomeStoriesModel) {
            binding.img.setImageResource(model.imageStories)
            binding.username.text = model.usernameStories
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            HomeStoriesRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<HomeStoriesModel>() {
        override fun areItemsTheSame(
            oldItem: HomeStoriesModel,
            newItem: HomeStoriesModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: HomeStoriesModel,
            newItem: HomeStoriesModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<HomeStoriesModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}