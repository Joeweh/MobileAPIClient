package com.github.joeweh.mobileapiclient

import kotlinx.serialization.Serializable

@Serializable
data class User(val email: String, val password: String)