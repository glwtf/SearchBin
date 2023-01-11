package com.example.searchbin.data

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.searchbin.domain.BinInfo
import com.example.searchbin.domain.SearchBinRepository
import java.text.SimpleDateFormat
import java.util.*

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
        //TODO("Add check bad result")
    }

    override suspend fun loadBinInfo(bin: String): BinInfo {
        val binInfoRequest = LoadBinInfo(bin)
        val binInfo = binInfoRequest()
        binInfo.bin = bin.toInt();
        binInfo.time = getCurrentTime()
        addSearchedBin(binInfo)
        return binInfo
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentTime() : String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return formatter.format(time)
    }

}