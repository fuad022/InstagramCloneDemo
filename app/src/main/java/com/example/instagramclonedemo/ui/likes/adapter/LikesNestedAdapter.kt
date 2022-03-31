package com.example.instagramclonedemo.ui.likes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.LikesNestedModel
import com.example.instagramclonedemo.databinding.LikesNestedRvItemBinding
import com.example.instagramclonedemo.util.Util.getStr

class LikesNestedAdapter :
    ListAdapter<LikesNestedModel, LikesNestedAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: LikesNestedRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: LikesNestedModel) {
            binding.ownerImg.setImageResource(model.ownerImg)
            binding.eventTxt.text = getStr(model.eventTxt)
            if (model.image != null) binding.img.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LikesNestedRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<LikesNestedModel>() {
        override fun areItemsTheSame(
            oldItem: LikesNestedModel,
            newItem: LikesNestedModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LikesNestedModel,
            newItem: LikesNestedModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<LikesNestedModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}