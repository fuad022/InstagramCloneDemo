package com.example.instagramclonedemo.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramclonedemo.data.model.SearchModel
import com.example.instagramclonedemo.databinding.TabsRvItemBinding

class SearchTabsAdapter : ListAdapter<SearchModel, SearchTabsAdapter.ItemHolder>(DiffCallback()) {

    inner class ItemHolder(private val binding: TabsRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SearchModel?) {
            model?.let { m ->
                if (m.icon != null) binding.tabBtn.setCompoundDrawablesWithIntrinsicBounds(m.icon, 0, 0, 0)
                binding.tabBtn.text = m.title
                binding.tabBtn.setOnClickListener {
                    m.let { searchModel -> setOnItemClick?.invoke(searchModel) }
                }
            }
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

    private var setOnItemClick: ((SearchModel) -> Unit)? = null

    fun setOnClickListener(listener: (SearchModel) -> Unit) { setOnItemClick = listener }
}