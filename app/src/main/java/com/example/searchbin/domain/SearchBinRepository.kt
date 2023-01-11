package com.example.searchbin.domain

import androidx.lifecycle.LiveData

interface SearchBinRepository {

    fun getSearchedBinList() : LiveData<List<BinInfo>>
    suspend fun addSearchedBin(binInfo: BinInfo)
    suspend fun getSearchedBinItem(bin : Int) : BinInfo
    suspend fun loadBinInfo(bin : String) : BinInfo
}