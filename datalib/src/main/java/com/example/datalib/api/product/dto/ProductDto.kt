package com.example.datalib.api.product.dto

/**
 *
 * Модель данных товара
 *
 * @property id Идентификатор товара
 * @property collectionId Идентификатор коллекции в базе данных
 * @property collectionName Название коллекции/таблицы товаров
 * @property created Дата и время создания записи
 * @property updated Дата и время последнего обновления
 * @property title Название товара
 * @property description Подробное описание товара
 * @property price Стоимость товара
 * @property typeCloses Тип одежды
 * @property type Категория товара
 * @property approximateCost Примерная стоимость
 */
data class ProductDto(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val description: String,
    val price: Int,
    val typeCloses: String,
    val type: String,
    val approximateCost: String
)
