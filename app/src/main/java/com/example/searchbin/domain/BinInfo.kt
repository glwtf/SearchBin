package com.example.searchbin.domain

import kotlinx.serialization.Serializable

@Serializable
data class BinInfo (
    var bin : Int = UNKNOWN_INT,
    val number : Number = Number(),
    val scheme : String = UNKNOWN_STRING,
    val type : String = UNKNOWN_STRING,
    val brand : String = UNKNOWN_STRING,
    val prepaid : Boolean = false,
    val country : Country = Country(),
    val bank : Bank = Bank(),
    var time : String = UNKNOWN_STRING
) : java.io.Serializable
{
    companion object {
        const val UNKNOWN_INT = 0
        const val UNKNOWN_STRING = "?"
    }
}