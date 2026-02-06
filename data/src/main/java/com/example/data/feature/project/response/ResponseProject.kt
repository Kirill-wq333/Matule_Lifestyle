package com.example.data.feature.project.response

import com.google.gson.annotations.SerializedName

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
    val items: Project
)

/**
 *
 * Модель проекта
 *
 * @property id Индификатор проекта
 * @property collectionId Индификатор коллекции в базе данных
 * @property collectionName Название коллекции/таблицы проектов
 * @property created Дата и время создания проекта
 * @property updated Дата и время обновленния проекта
 * @property title Название проекта
 * @property dateStart Дата начала проекта
 * @property dateEnd Дата окончания проекта
 * @property gender Пол пользователя
 * @property descriptionSource Источник описания
 * @property category Категория проекта
 * @property image Картинка проекта
 * @property userId Индификатор пользователя
 */
data class Project(
    val id: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val updated: String,
    val title: String,
    val dateStart: String,
    val dateEnd: String,
    val gender: String,
    @SerializedName("description_source")val descriptionSource: String,
    val category: String,
    val image: String,
    @SerializedName("user_id")val userId: String
)
