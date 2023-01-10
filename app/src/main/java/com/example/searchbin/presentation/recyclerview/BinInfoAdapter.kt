package com.example.searchbin.presentation.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.searchbin.databinding.ItemSearchResultBinding
import com.example.searchbin.domain.BinInfo
import java.text.SimpleDateFormat
import java.util.*

class BinInfoAdapter() : ListAdapter<BinInfo, BinInfoViewHolder>(BinInfoDiffCallBack()) {

    var onSearchedItemClickListener : ((BinInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinInfoViewHolder {
        val binding = ItemSearchResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BinInfoViewHolder, position: Int) {
        val item = getItem(position)
        val binding = holder.binding

        binding.tvSearchedBin.text = item.bin.toString()
        binding.tvSearchTime.text = item.time

        binding.root.setOnClickListener {
            onSearchedItemClickListener?.invoke(item)
        }
    }
}