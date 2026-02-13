package com.example.domain.ui.feature.auth.model.response

import com.example.domain.ui.feature.profile.model.User

data class ResponseAuth(
    val token: String,
    val record: User
)