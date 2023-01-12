package com.example.searchbin.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Number(
    val length : Int = BinInfo.UNKNOWN_INT,
    val luhn : Boolean = false
) : java.io.Serializable

@Serializable
class Country(
    val numeric : String = BinInfo.UNKNOWN_STRING,
    val alpha2 : String = BinInfo.UNKNOWN_STRING,
    @SerialName("name")
    val nameCountry : String = BinInfo.UNKNOWN_STRING,
    val currency : String = BinInfo.UNKNOWN_STRING,
    val latitude : Int = BinInfo.UNKNOWN_INT,
    val  longitude : Int = BinInfo.UNKNOWN_INT
) : java.io.Serializable

@Serializable
class Bank(
    @SerialName("name")
    val nameBank : String = BinInfo.UNKNOWN_STRING,
    val url : String = BinInfo.UNKNOWN_STRING,
    val phone : String = BinInfo.UNKNOWN_STRING,
    val city : String = BinInfo.UNKNOWN_STRING
) : java.io.Serializable