package com.example.data.feature.auth

import com.example.data.feature.auth.datasource.AuthApiService
import com.example.data.feature.auth.dto.request.RequestAuth
import com.example.data.feature.auth.dto.request.RequestRegister
import com.example.data.feature.auth.dto.response.ResponseAuthDto.Companion.toResponseAuth
import com.example.data.feature.auth.dto.response.ResponseRegisterDto.Companion.toResponseRegister
import com.example.domain.ui.feature.auth.model.response.ResponseAuth
import com.example.domain.ui.feature.auth.model.response.ResponseRegister
import com.example.domain.ui.feature.auth.repository.AuthRepository

class AuthRepositoryImpl(
    private val apiService: AuthApiService
): AuthRepository {
    override suspend fun register(
        email: String,
        password: String,
        passwordConfirm: String
    ): Result<ResponseRegister> = runCatching {
        val response = apiService.postRegister(request = RequestRegister(email, password, passwordConfirm))
        Result.success(response.toResponseRegister())
    }.fold(
        onSuccess = { it },
        onFailure = { Result.failure(it) }
    )

    override suspend fun auth(identity: String, password: String): Result<ResponseAuth> = runCatching {
        val response = apiService.postAuth(RequestAuth(identity, password))
        Result.success(response.toResponseAuth())
    }.fold(
        onFailure = { Result.failure(it) },
        onSuccess = { it }
    )

    override suspend fun exitSystem(idToken: String): Result<Unit> = runCatching {
        val response = apiService.exitSystem(idToken)
        Result.success(response)
    }

}