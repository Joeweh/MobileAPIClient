package com.github.joeweh.mobileapiclient.ui.register

import androidx.lifecycle.ViewModel
import com.github.joeweh.mobileapiclient.User
import com.github.joeweh.mobileapiclient.utils.Http
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterViewModel: ViewModel() {
    suspend fun register(email: String, pw: String): Unit = withContext(Dispatchers.IO) {

        val response = Http.client.request {
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