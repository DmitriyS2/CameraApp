package com.example.cameraapp

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cameraapp.databinding.ItemLayoutBinding

class ItemAdapter : ListAdapter<Item, ItemAdapter.ItemHolder>(ItemDiffCallback()) {

    class ItemHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemLayoutBinding.bind(item)

        fun bind(item: Item) {
            binding.currentPhoto.setImageURI(Uri.parse(item.path))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}