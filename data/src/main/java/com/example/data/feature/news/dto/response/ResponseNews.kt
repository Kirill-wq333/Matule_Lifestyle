package com.example.data.feature.news.dto.response

import com.example.data.feature.news.dto.NewsDto

/**
 *
 * Ответ добавленных "Новостей и акций"
 *
 * @property page Текущая страница
 * @property perPage Следущая страница
 * @property totalPages Количество страниц
 * @property totalItems Количество новостей и акций
 * @property items Список новостей и акций
 */
data class ResponseNews(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<NewsDto>
)
