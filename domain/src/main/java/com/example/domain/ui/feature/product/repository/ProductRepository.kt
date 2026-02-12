package com.example.domain.ui.feature.product.repository

import com.example.domain.ui.feature.product.model.Product
import com.example.domain.ui.feature.product.model.Products

interface ProductRepository {
    suspend fun product(productId: String): Result<Product>
    suspend fun products(): Result<List<Products>>
}