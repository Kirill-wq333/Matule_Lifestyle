package com.example.domain.ui.feature.order.interactor

import com.example.domain.ui.feature.order.repository.OrderRepository

class OrderInteractor(
    private val orderRepository: OrderRepository
) {
    suspend fun postOrder(userId: String, productId: String, count: Int): Result<Unit> {
        return orderRepository.postOrder(userId, productId, count)
    }
}