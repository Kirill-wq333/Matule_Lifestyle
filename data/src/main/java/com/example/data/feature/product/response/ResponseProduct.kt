package com.example.data.feature.product.response

data class ResponseProduct(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<Product>
)

data class Product(
    val id: String,
    val title: String,
    val price: Int,
    val typeCloses: String,
    val type: String
)