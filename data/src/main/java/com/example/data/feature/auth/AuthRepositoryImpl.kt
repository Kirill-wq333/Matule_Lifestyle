package com.example.data.feature.auth

import com.example.data.feature.auth.datasource.AuthApiService
import com.example.data.feature.auth.dto.request.RequestAuth
import com.example.data.feature.auth.dto.request.RequestRegister
import com.example.domain.ui.feature.auth.repository.AuthRepository

class AuthRepositoryImpl(
    private val apiService: AuthApiService
): AuthRepository {
    override suspend fun register(
        email: String,
        password: String,
        passwordConfirm: String
    ): Result<Unit> = runCatching {
        val response = apiService.postRegister(request = RequestRegister(email, password, passwordConfirm))
        Result.success(response)
    }

    override suspend fun auth(identity: String, password: String): Result<Unit> = runCatching {
        val response = apiService.postAuth(RequestAuth(identity, password))
        Result.success(response)
    }

    override suspend fun exitSystem(idToken: Int): Result<Unit> = runCatching {
        val response = apiService.exitSystem(idToken)
        Result.success(response)
    }

}