package com.example.searchbin.data

import com.example.searchbin.domain.BinInfo
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class LoadBinInfo(private val userBin: String) {

    private val js = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
        explicitNulls = false
    }
    private val client = HttpClient(CIO){
        install(ContentNegotiation) {
            json(js)
        }
    }
    private val fullUrl = URL_PREFIX+userBin

    suspend operator fun invoke() : BinInfo
        = client.get(fullUrl).body()

    companion object {
        const val URL_PREFIX = "https://lookup.binlist.net/"
    }
}