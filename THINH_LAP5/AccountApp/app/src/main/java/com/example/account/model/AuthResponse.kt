package com.example.account.model

data class AuthResponse(
    val success: Boolean,
    val message: String,
    val data: UserDto? = null
)

data class UserDto(
    val id: Int?,
    val email: String
)

