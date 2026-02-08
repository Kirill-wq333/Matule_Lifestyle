package com.example.data.feature.product.dto

import com.example.domain.ui.feature.product.model.Product

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
){
    companion object{
        fun ProductDto.toProduct(): Product =
            Product(
                id = id,
                collectionId = collectionId,
                collectionName = collectionName,
                created = created,
                updated = updated,
                title = title,
                description = description,
                price = price,
                typeCloses = typeCloses,
                type = type,
                approximateCost = approximateCost
            )
    }
}
