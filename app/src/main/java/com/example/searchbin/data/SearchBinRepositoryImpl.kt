package com.example.searchbin.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.domain.SearchBinRepository

class SearchBinRepositoryImpl(application: Application) : SearchBinRepository
{
    private val binInfoDao = AppDataBase.getInstance(application).binInfoListDao()
    private val mapper = BinInfoMapper()

    override fun getSearchedBinList(): LiveData<List<BinInfo>>
        = Transformations.map(binInfoDao.getBinInfoList()) {
            mapper.mapListDbModelToListEntity(it)
    }

    override suspend fun addSearchedBin(binInfo: BinInfo) {
        val item = mapper.mapEntityToDbModel(binInfo)
        binInfoDao.addSearchedBinInfo(item)
    }

    override suspend fun getSearchedBinItem(bin: String): BinInfo? {
        val binInt = bin.toInt()
        val item = binInfoDao.getSearchedBinInfo(binInt)
        return mapper.mapDbModelToEntity(item)
        TODO("Add check bad result")
    }

    override suspend fun loadBinInfo(bin: String): Boolean {
        val binInfoRequest = LoadBinInfo(bin)
        val binInfo = binInfoRequest()
        binInfo.bin = bin.toInt();
        addSearchedBin(binInfo)
        return true
        TODO("Add check bad result")
    }

}