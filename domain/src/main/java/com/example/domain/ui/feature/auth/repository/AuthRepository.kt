package com.example.domain.ui.feature.auth.repository

interface AuthRepository {
    suspend fun register(email: String, password: String, passwordConfirm: String): Result<Unit>
    suspend fun auth(identity: String, password: String): Result<Unit>
    suspend fun exitSystem(idToken: Int): Result<Unit>
}