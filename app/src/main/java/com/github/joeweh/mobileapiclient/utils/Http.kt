package com.github.joeweh.mobileapiclient.utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

class Http {
    companion object {
        val client = HttpClient(CIO) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 10000
            }
            install(Auth) {}
            install(ContentNegotiation) {
                json()
            }
        }
    }
}