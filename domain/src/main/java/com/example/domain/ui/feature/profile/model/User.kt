package com.example.domain.ui.feature.profile.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val emailVisibility: Boolean,
    val firstname: String,
    val id: String,
    val lastname: String,
    val secondname: String,
    val updated: String,
    val verified: String,
    val datebirthday: String,
    val gender: String
)
