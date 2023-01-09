package com.example.searchbin.domain

import kotlinx.serialization.Serializable

@Serializable
class BinInfo (
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