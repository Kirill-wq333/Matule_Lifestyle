package com.example.data.feature.product.dto

import com.example.domain.ui.feature.product.model.Products

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
){
    companion object{
        fun ProductsDto.toProducts(): Products =
            Products(
                id = id,
                title = title,
                price = price,
                typeCloses = typeCloses,
                type = type
            )
    }
}