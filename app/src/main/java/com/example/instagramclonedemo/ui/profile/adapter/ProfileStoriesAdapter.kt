package com.example.instagramclonedemo.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.ProfileModel
import com.example.instagramclonedemo.databinding.ProfileStoriesRvItemBinding

class ProfileStoriesAdapter : ListAdapter<ProfileModel, ProfileStoriesAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: ProfileStoriesRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ProfileModel) {
            binding.img.setImageResource(model.image)
            binding.title.text = model.profileStoriesName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ProfileStoriesRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<ProfileModel>() {
        override fun areItemsTheSame(
            oldItem: ProfileModel,
            newItem: ProfileModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ProfileModel,
            newItem: ProfileModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<ProfileModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}