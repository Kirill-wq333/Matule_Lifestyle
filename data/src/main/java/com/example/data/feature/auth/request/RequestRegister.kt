package com.example.data.feature.auth.request

data class RequestRegister(
    val email: String,
    val password: String,
    val passwordConFirm: String
)