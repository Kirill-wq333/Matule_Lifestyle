package com.example.data.feature.order.response

import com.google.gson.annotations.SerializedName

data class ResponseOrders(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
