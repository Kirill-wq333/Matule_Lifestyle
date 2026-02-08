package com.example.domain.ui.feature.auth.interactor

import com.example.domain.ui.feature.auth.repository.AuthRepository

class AuthInteractor(
    private val authRepository: AuthRepository
) {
    suspend fun register(email: String, password: String, passwordConfirm: String): Result<Unit> {
        return authRepository.register(email, password, passwordConfirm)
    }

    suspend fun auth(identity: String, password: String): Result<Unit> {
        return authRepository.auth(identity, password)
    }

    suspend fun exitSystem(idToken: Int): Result<Unit> {
        return authRepository.exitSystem(idToken)
    }
}