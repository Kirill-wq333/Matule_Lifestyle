package com.example.domain.ui.feature.order.repository

interface OrderRepository {
    suspend fun postOrder(userId: String, productId: String, count: Int): Result<Unit>
}