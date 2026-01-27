package com.example.data.feature.product.datasource

import com.example.data.feature.product.model.Product
import com.example.data.feature.product.response.ResponseProduct
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {

    @WithAuthorization
    @GET(NetworkConfig.Routes.PRODUCTS)
    suspend fun getProducts(): ResponseProduct

    @WithAuthorization
    @GET("${NetworkConfig.Routes.PRODUCTS}/{id_product}")
    suspend fun getProduct(@Path("id_product") idProduct: Int): Product

}