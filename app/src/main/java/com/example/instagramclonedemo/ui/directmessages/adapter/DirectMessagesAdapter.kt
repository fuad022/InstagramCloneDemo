package com.example.instagramclonedemo.ui.directmessages.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.DirectMessagesModel
import com.example.instagramclonedemo.databinding.MessageItemBinding

class DirectMessagesAdapter : ListAdapter<DirectMessagesModel, DirectMessagesAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: MessageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: DirectMessagesModel) {
            binding.img.setImageResource(model.imageProfileMessages)
            binding.username.text = model.usernameMessages
            binding.message.text = model.textMessages
            binding.time.text = model.timeMessages
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            MessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<DirectMessagesModel>() {
        override fun areItemsTheSame(
            oldItem: DirectMessagesModel,
            newItem: DirectMessagesModel
        ) = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: DirectMessagesModel,
            newItem: DirectMessagesModel
        ) = oldItem == newItem
    }

    override fun submitList(list: List<DirectMessagesModel>?) {
        super.submitList(list?.map { it.copy() })
    }
}