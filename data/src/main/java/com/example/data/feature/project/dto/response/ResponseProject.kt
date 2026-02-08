package com.example.data.feature.project.dto.response

import com.example.data.feature.project.dto.ProjectDto

/**
 *
 * Ответ добавленных проектов
 *
 * @property page Текущая страница
 * @property perPage Следущая страница
 * @property totalPages Количество страниц
 * @property totalItems Количество новостей и акций
 * @property items Список проектов
 */
data class ResponseProject(
    val page: Int,
    val perPage: Int,
    val totalPages: Int,
    val totalItems: Int,
    val items: List<ProjectDto>
)
