package com.example.account.data.repository

import com.example.account.data.remote.AuthApiService
import com.example.account.model.AuthRequest
import com.example.account.model.AuthResponse
import com.example.account.model.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(private val service: AuthApiService) {

    suspend fun login(email: String, password: String): Result<AuthResponse> =
        execute { service.login(AuthRequest(email, password)) }

    suspend fun register(email: String, password: String): Result<AuthResponse> =
        execute { service.register(RegisterRequest(email, password)) }

    private suspend fun execute(block: suspend () -> retrofit2.Response<AuthResponse>): Result<AuthResponse> =
        withContext(Dispatchers.IO) {
            runCatching {
                val response = block()
                if (!response.isSuccessful) {
                    throw IllegalStateException("Máy chủ trả về lỗi ${response.code()}")
                }
                response.body() ?: throw IllegalStateException("Không có dữ liệu trả về")
            }
        }
}

