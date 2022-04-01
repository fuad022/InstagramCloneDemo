package com.example.instagramclonedemo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.HomePostModel
import com.example.instagramclonedemo.databinding.HomePostRvItemBinding
import com.example.instagramclonedemo.util.Util.getStr

class HomePostAdapter : ListAdapter<HomePostModel, HomePostAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: HomePostRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: HomePostModel) {
            binding.profileImg.setImageResource(model.imageProfilePost)
            binding.username.text = model.usernamePost
            binding.location.text = model.locationPost
            binding.postImg.setImageResource(model.imagePost)
            binding.likerImg.setImageResource(model.imageLiker)
            binding.likedCount.text = getStr(model.likedCountPost)
            binding.commentTxt.text = getStr(model.commentPost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            HomePostRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<HomePostModel>() {
        override fun areItemsTheSame(
            oldItem: HomePostModel,
            newItem: HomePostModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: HomePostModel,
            newItem: HomePostModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<HomePostModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}