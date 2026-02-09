package com.example.datalib.api.product.dto

/**
 *
 * Данные товара
 *
 * @property id Индификатор товара
 * @property title Название товара
 * @property price Стоимость товара
 * @property typeCloses Тип одежды товара
 * @property type Категория товара
 */
data class ProductsDto(
    val id: String,
    val title: String,
    val price: Int,
    val typeCloses: String,
    val type: String
)