package com.example.searchbin.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Number(
    val length : Int,
    val luhn : Boolean
)

@Serializable
class Country(
    val numeric : String,
    val alpha2 : String,
    @SerialName("name")
    val nameCountry : String,
    //val emoji : Image,
    val currency : String,
    val latitude : Int,
    val  longitude : Int
)

@Serializable
class Bank(
    @SerialName("name")
    val nameBank : String,
    val url : String,
    val phone : String,
    val city : String
)