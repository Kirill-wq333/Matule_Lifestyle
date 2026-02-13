package com.example.domain.ui.feature.auth.repository

import com.example.domain.ui.feature.auth.model.response.ResponseAuth
import com.example.domain.ui.feature.auth.model.response.ResponseRegister

interface AuthRepository {
    suspend fun register(email: String, password: String, passwordConfirm: String): Result<ResponseRegister>
    suspend fun auth(identity: String, password: String): Result<ResponseAuth>
    suspend fun exitSystem(idToken: String): Result<Unit>
}