package com.example.data.feature.product

import com.example.data.feature.product.datasource.ProductApiService
import com.example.data.feature.product.dto.ProductDto.Companion.toProduct
import com.example.data.feature.product.dto.ProductsDto.Companion.toProducts
import com.example.domain.ui.feature.product.model.Product
import com.example.domain.ui.feature.product.model.Products
import com.example.domain.ui.feature.product.repository.ProductRepository

class ProductRepositoryImpl(
    private val apiService: ProductApiService
) : ProductRepository {
    override suspend fun product(productId: String): Result<Product> = runCatching {
        val response = apiService.getProduct(productId)
        Result.success(response.toProduct())
    }.fold(
        onSuccess = { it },
        onFailure = { Result.failure(it) }
    )

    override suspend fun products(): Result<List<Products>> = runCatching {
        val response = apiService.getProducts()
        Result.success(response.items.map { it.toProducts() })
    }.fold(
        onFailure = { Result.failure(it) },
        onSuccess = { it }
    )
}