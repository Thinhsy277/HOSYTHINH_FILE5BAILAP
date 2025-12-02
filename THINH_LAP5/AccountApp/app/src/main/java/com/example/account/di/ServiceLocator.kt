package com.example.account.di

import com.example.account.data.remote.ApiClient
import com.example.account.data.remote.AuthApiService
import com.example.account.data.repository.AuthRepository

/**
 * Very small dependency container used to provide singletons without Dagger/Hilt.
 */
object ServiceLocator {
    private val authApiService: AuthApiService by lazy {
        ApiClient.retrofit.create(AuthApiService::class.java)
    }

    val authRepository: AuthRepository by lazy {
        AuthRepository(authApiService)
    }
}

