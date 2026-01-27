package com.example.data.feature.auth.response

import com.example.data.feature.profile.model.User

data class ResponseAuth(
    val token: String,
    val record: User
)

