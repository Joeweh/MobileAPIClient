package com.github.joeweh.mobileapiclient.utils

import com.github.joeweh.mobileapiclient.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HttpTest {
    companion object {
        private val client = HttpClient(CIO) {
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 5000
            }
            install(Auth) {}
            install(ContentNegotiation) {
                json()
            }
        }

        fun register(email: String, pw: String): Unit = runBlocking {
            launch {
                val response = client.request {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "actix-rest-api.onrender.com"
                        path("/api/users/register")
                    }

                    method = HttpMethod.Post

                    contentType(ContentType.Application.Json)
                    setBody(User(email, pw))
                }

                val code = response.status

                println(code)
            }
        }

        fun login(email: String, pw: String): Unit = runBlocking {
            launch {
                val response = client.request {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "actix-rest-api.onrender.com"
                        path("/api/users/login")
                    }

                    method = HttpMethod.Post

                    contentType(ContentType.Application.Json)
                    setBody(User(email, pw))
                }

                val body: String = response.body()

                println("Body: $body")
            }
        }

        fun changePassword(authToken: String): Unit = runBlocking {
            launch {
                val response = client.request {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "actix-rest-api.onrender.com"
                        path("/api/users/change-password")
                    }

                    method = HttpMethod.Put
                }

                val code = response.status

                println(code)
            }
        }

    }
}