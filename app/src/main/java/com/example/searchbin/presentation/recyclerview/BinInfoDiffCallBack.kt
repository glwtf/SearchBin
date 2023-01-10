package com.example.searchbin.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.searchbin.domain.BinInfo

class BinInfoDiffCallBack : DiffUtil.ItemCallback<BinInfo>() {
    override fun areItemsTheSame(oldItem: BinInfo, newItem: BinInfo): Boolean {
        return oldItem.bin == newItem.bin //нет параметра для проверки
    }

    override fun areContentsTheSame(oldItem: BinInfo, newItem: BinInfo): Boolean {
        return oldItem == newItem
    }
}