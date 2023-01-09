package com.example.searchbin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.searchbin.domain.Bank
import com.example.searchbin.domain.Country
import com.example.searchbin.domain.Number

@Entity(tableName = "bin_info_items")
class BinInfoDbModel (
    @PrimaryKey val bin : Int,
    val number : Number,
    val scheme : String,
    val type : String,
    val brand : String,
    val prepaid : Boolean,
    val country : Country,
    val bank : Bank
)
{
}