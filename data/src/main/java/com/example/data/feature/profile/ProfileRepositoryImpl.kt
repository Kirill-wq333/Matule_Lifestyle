package com.example.data.feature.profile

import com.example.data.feature.profile.datasource.ProfileApiService
import com.example.data.feature.profile.dto.UserDto.Companion.toUser
import com.example.data.feature.profile.dto.request.RequestUser
import com.example.domain.ui.feature.profile.model.User
import com.example.domain.ui.feature.profile.repository.ProfileRepository

class ProfileRepositoryImpl(
    private val apiService: ProfileApiService
) : ProfileRepository {
    override suspend fun user(userId: Int): Result<User> = runCatching {
        val response = apiService.getUser(userId)
        Result.success(response.toUser())
    }.fold(
        onFailure = {  Result.failure(it) },
        onSuccess = { it }
    )

    override suspend fun patchUser(
        userId: Int,
        email: String,
        emailVisibility: Boolean,
        firstname: String,
        lastname: String,
        secondname: String,
        datebirthday: String,
        gender: String
    ): Result<User> = runCatching {
        val response = apiService.patchUser(
            userId,
            RequestUser(
                email,
                emailVisibility,
                firstname,
                lastname,
                secondname,
                datebirthday,
                gender
            )
        )
        Result.success(response.toUser())
    }.fold(
        onFailure = {  Result.failure(it) },
        onSuccess = { it }
    )
}