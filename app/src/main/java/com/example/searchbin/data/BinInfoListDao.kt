package com.example.searchbin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BinInfoListDao {

    @Query("SELECT * FROM bin_info_items")
    fun getBinInfoList() : LiveData<List<BinInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearchedBinInfo(binInfoDbModel : BinInfoDbModel)

    @Query("SELECT * FROM bin_info_items WHERE bin=:binInt LIMIT 1")
    suspend fun getSearchedBinInfo(binInt: Int) : BinInfoDbModel

}