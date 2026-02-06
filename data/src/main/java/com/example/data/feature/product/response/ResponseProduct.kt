package com.example.data.feature.product.response

/**
 *
 * Ответ добавленных Товаров
 *
 * @property page Текущая страница
 * @property perPage Следущая страница
 * @property totalPages Количество страниц
 * @property totalItems Количество новостей и акций
 * @property items Список продуктов
 */
data class ResponseProduct(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<Product>
)

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
data class Product(
    val id: String,
    val title: String,
    val price: Int,
    val typeCloses: String,
    val type: String
)