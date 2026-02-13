package com.example.domain.ui.feature.auth.interactor

import com.example.domain.ui.feature.auth.model.response.ResponseAuth
import com.example.domain.ui.feature.auth.model.response.ResponseRegister
import com.example.domain.ui.feature.auth.repository.AuthRepository

class AuthInteractor(
    private val authRepository: AuthRepository
) {
    suspend fun register(email: String, password: String, passwordConfirm: String): Result<ResponseRegister> {
        return authRepository.register(email, password, passwordConfirm)
    }

    suspend fun auth(identity: String, password: String): Result<ResponseAuth> {
        return authRepository.auth(identity, password)
    }

    suspend fun exitSystem(idToken: String): Result<Unit> {
        return authRepository.exitSystem(idToken)
    }
}