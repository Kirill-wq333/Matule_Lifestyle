package com.example.domain.ui.feature.profile.repository

import com.example.domain.ui.feature.profile.model.User

interface ProfileRepository {
    suspend fun user(userId: String): Result<User>
    suspend fun patchUser(
        userId: String,
        email: String,
        emailVisibility: Boolean,
        firstname: String,
        lastname: String,
        secondname: String,
        datebirthday: String,
        gender: String
    ): Result<User>
}