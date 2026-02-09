package com.example.datalib.api.product.dto.response

import com.example.datalib.api.product.dto.ProductsDto

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
    val items: List<ProductsDto>
)
