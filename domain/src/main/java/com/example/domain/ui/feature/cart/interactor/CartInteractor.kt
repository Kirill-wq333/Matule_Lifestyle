package com.example.domain.ui.feature.cart.interactor

import com.example.domain.ui.feature.cart.repository.CartRepository

class CartInteractor(
    private val cartRepository: CartRepository
) {
    suspend fun postCart(userId: String, productId: String, count: Int): Result<Unit> {
        return  cartRepository.postCart(userId, productId, count)
    }

    suspend fun patchCart(idBBucket: String, userId: String, productId: String, count: Int): Result<Unit>{
        return cartRepository.patchCart(idBBucket, userId, productId, count)
    }
}