package com.example.instagramclonedemo.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.SearchModel
import com.example.instagramclonedemo.databinding.TabsRvItemBinding

class SearchTabsAdapter : ListAdapter<SearchModel, SearchTabsAdapter.ItemHolder>(DiffCallback()) {

    class ItemHolder(private val binding: TabsRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SearchModel) {
            if (model.icon != null) binding.tabBtn.setCompoundDrawablesWithIntrinsicBounds(model.icon, 0, 0, 0)
            binding.tabBtn.text = model.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            TabsRvItemBinding.inflate(
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