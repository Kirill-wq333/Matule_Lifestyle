package com.example.data.feature.cart.datasource

import com.example.data.feature.cart.request.RequestCart
import com.example.data.feature.cart.response.ResponseCart
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CartApiService {

    @WithAuthorization
    @POST(NetworkConfig.Routes.CART)
    suspend fun postCart(request: RequestCart): ResponseCart

    @WithAuthorization
    @PATCH("${NetworkConfig.Routes.CART}/{id_bucket}")
    suspend fun patchCart(@Path("id_bucket") idBucket: Int, request: RequestCart): ResponseCart

}