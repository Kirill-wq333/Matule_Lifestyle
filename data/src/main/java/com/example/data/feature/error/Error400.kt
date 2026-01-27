package com.example.data.feature.error

data class Error400(
    val status: Int,
    val message: String,
    val data: List<String>
)
