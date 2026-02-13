package com.example.domain.ui.feature.profile.interactor

import com.example.domain.ui.feature.profile.model.User
import com.example.domain.ui.feature.profile.repository.ProfileRepository

class ProfileInteractor(
    private val profileRepository: ProfileRepository
) {
    suspend fun user(userId: String): Result<User>{
        return profileRepository.user(userId)
    }

    suspend fun patchUser(
        userId: String,
        email: String,
        emailVisibility: Boolean,
        firstname: String,
        lastname: String,
        secondname: String,
        datebirthday: String,
        gender: String
    ): Result<User>{
        return profileRepository.patchUser(
            userId,
            email,
            emailVisibility,
            firstname,
            lastname,
            secondname,
            datebirthday,
            gender
        )
    }
}