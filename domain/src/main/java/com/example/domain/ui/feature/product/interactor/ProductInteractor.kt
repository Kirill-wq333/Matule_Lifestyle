package com.example.domain.ui.feature.product.interactor

import com.example.domain.ui.feature.product.model.Product
import com.example.domain.ui.feature.product.model.Products
import com.example.domain.ui.feature.product.repository.ProductRepository

class ProductInteractor(
    private val productRepository: ProductRepository
) {
    suspend fun product(productId: Int): Result<Product> {
        return productRepository.product(productId)
    }
    suspend fun products(): Result<List<Products>>{
        return productRepository.products()
    }
}