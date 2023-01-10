package com.example.searchbin.domain

import kotlinx.serialization.Serializable

@Serializable
data class BinInfo (
    var bin : Int,
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