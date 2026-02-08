package com.example.domain.ui.feature.cart.repository

interface CartRepository {
    suspend fun postCart(userId: String, productId: String, count: Int): Result<Unit>
    suspend fun patchCart(idBBucket: Int, userId: String, productId: String, count: Int): Result<Unit>
}