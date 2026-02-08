package com.example.data.feature.order.dto.request

import com.google.gson.annotations.SerializedName
/**
 *
 * Запрос на создание заказа
 *
 * @property userId Индификатор пользователя
 * @property productId Индификатор продукта
 * @property count Количество продуктов в заказе
 */
data class RequestOrders(
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
