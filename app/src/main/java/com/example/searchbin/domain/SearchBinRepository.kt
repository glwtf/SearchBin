package com.example.searchbin.domain

import androidx.lifecycle.LiveData

interface SearchBinRepository {

    fun getSearchedBinList() : LiveData<List<BinInfo>>
    suspend fun addSearchedBin(binInfo: BinInfo, bin : String)
    suspend fun getSearchedBinItem(bin : String) : BinInfo?
    suspend fun loadBinInfo(bin : String) : Boolean
}