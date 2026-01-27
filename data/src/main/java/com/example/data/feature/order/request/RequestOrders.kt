package com.example.data.feature.order.request

import com.google.gson.annotations.SerializedName

data class RequestOrders(
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
