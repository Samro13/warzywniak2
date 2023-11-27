package com.example.warzywniak

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json

class RestAPI {

    companion object {
        const val api = "https://www.thecocktaildb.com/api/json/v1/1/"
    }

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json( Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        install(HttpTimeout) {
            val timeout = 15000L
            requestTimeoutMillis = timeout
            socketTimeoutMillis = timeout
            connectTimeoutMillis = timeout
        }
        defaultRequest {
            url(api)
        }
    }


    suspend fun getDrinksBy(name: String): HttpResponse {
        return httpClient.get("search.php?s=${name}")
    }

    suspend fun drinki2(id: String): HttpResponse {
        return httpClient.get("lookup.php?i=${id}")
    }

}