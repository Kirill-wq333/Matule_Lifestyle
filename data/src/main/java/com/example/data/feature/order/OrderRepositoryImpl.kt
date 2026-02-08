package com.example.data.feature.order

import com.example.data.feature.order.datasource.OrderApiService
import com.example.data.feature.order.dto.request.RequestOrders
import com.example.domain.ui.feature.order.repository.OrderRepository

class OrderRepositoryImpl(
    private val apiService: OrderApiService
): OrderRepository {
    override suspend fun postOrder(userId: String, productId: String, count: Int): Result<Unit> = runCatching {
        val response = apiService.postOrders(RequestOrders(userId, productId, count))
        Result.success(response)
    }
}