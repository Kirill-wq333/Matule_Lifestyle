package com.example.data.feature.cart.dto.response

import com.google.gson.annotations.SerializedName

/**
 *
 * Ответ добавленных и обновленных товаров в корзине пользователя
 *
 * @property id Индификатор корзины
 * @property collectionId Идентификатор коллекции/таблицы корзины в базе данных
 * @property collectionName Название коллекции/таблицы корзины
 * @property created Дата и время последнего создания корзины
 * @property updated Дата и время последнего обновления корзины
 * @property userId Индификатор пользователя
 * @property productId Индификатор продукта
 * @property count Количество товаров
 */
data class ResponseCart(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    @SerializedName("user_id") val userId: String,
    @SerializedName("product_id") val productId: String,
    val count: Int
)
