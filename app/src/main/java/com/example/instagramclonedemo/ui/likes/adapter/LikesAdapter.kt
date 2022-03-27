package com.example.instagramclonedemo.ui.likes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.LikesModel
import com.example.instagramclonedemo.databinding.LikesRvItemBinding

class LikesAdapter : ListAdapter<LikesModel, LikesAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: LikesRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: LikesModel) {
            binding.ownerImg.setImageResource(model.ownerImg)
            binding.eventTxt.text = model.eventTxt
            if (model.image != null) binding.img.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LikesRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<LikesModel>() {
        override fun areItemsTheSame(
            oldItem: LikesModel,
            newItem: LikesModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LikesModel,
            newItem: LikesModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<LikesModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}