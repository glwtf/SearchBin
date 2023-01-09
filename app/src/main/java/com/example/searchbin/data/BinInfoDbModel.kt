package com.example.searchbin.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.searchbin.domain.Bank
import com.example.searchbin.domain.Country
import com.example.searchbin.domain.Number

@Entity(tableName = "bin_info_items")
class BinInfoDbModel (
    @PrimaryKey val bin : Int,
    @Embedded val number : Number,
    val scheme : String,
    val type : String,
    val brand : String,
    val prepaid : Boolean,
    @Embedded val country : Country,
    @Embedded val bank : Bank
)
{
}