package com.example.data.feature.cart

import com.example.data.feature.cart.datasource.CartApiService
import com.example.data.feature.cart.dto.request.RequestCart
import com.example.domain.ui.feature.cart.repository.CartRepository

class CartRepositoryImpl(
    private val apiService: CartApiService
) : CartRepository {
    override suspend fun postCart(userId: String, productId: String, count: Int): Result<Unit> = runCatching {
        val response = apiService.postCart(RequestCart(userId, productId, count))
        Result.success(response)
    }

    override suspend fun patchCart(
        idBBucket: String,
        userId: String,
        productId: String,
        count: Int
    ): Result<Unit> = runCatching {
        val response = apiService.patchCart(idBBucket, RequestCart(userId, productId, count))
        Result.success(response)
    }
}