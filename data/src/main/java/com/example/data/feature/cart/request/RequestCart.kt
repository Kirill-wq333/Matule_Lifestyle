package com.example.data.feature.cart.request

import com.google.gson.annotations.SerializedName

data class RequestCart(
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
