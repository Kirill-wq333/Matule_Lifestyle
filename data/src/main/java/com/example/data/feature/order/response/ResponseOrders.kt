package com.example.data.feature.order.response

import com.google.gson.annotations.SerializedName

/**
 *
 * Ответ добавленных товаров в заказ
 *
 * @property id Индификатор заказа
 * @property collectionId Идентификатор коллекции/таблицы заказа в базе данных
 * @property collectionName Название коллекции/таблицы заказа
 * @property created Дата и время последнего создания заказа
 * @property updated Дата и время последнего обновления заказа
 * @property userId Индификатор пользователя
 * @property productId Индификатор товара
 * @property count Количество товаров в заказе
 */
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
