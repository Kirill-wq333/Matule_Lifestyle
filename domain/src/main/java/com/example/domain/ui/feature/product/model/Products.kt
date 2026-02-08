package com.example.domain.ui.feature.product.model

import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val id: String,
    val title: String,
    val price: Int,
    val typeCloses: String,
    val type: String
)
