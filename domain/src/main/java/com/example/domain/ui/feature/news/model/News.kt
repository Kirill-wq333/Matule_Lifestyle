package com.example.domain.ui.feature.news.model

import kotlinx.serialization.Serializable

@Serializable
data class News(
    val collectionId: String,
    val collectionName: String,
    val id: String,
    val newsImage: String,
    val created: String,
    val updated: String
)