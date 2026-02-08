package com.example.data.feature.cart.dto.request

import com.google.gson.annotations.SerializedName
/**
 *
 * Запрос на добавление или обновление товара в корзине пользователя.
 *
 * @property userId Идентификатор пользователя, владельца корзины
 * @property productId Идентификатор товара для добавления/обновления
 * @property count Количество товара (должно быть положительным числом)
 */
data class RequestCart(
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
