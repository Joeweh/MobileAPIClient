package com.github.joeweh.mobileapiclient.ui.home

import androidx.lifecycle.ViewModel

import com.github.joeweh.mobileapiclient.utils.Http

import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    suspend fun changePassword(authToken: String): Unit = withContext(Dispatchers.IO) {

        val response = Http.client.request {
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