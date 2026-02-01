package com.example.data.feature.project.request

import com.google.gson.annotations.SerializedName

/**
 *
 * Запрос на создание проекта
 *
 * @property title Название проекта
 * @property typeProject Тип проекта
 * @property userId Индификатор пользователя
 * @property dateStart Дата начала проекта
 * @property dateEnd Дата окончания проекта
 * @property gender Пол пользователя
 * @property descriptionSource Источник описания
 * @property category Категория
 * @property image Картинка проекта
 */
data class RequestProject(
    val title: String,
    val typeProject: String,
    @SerializedName("user_id")val userId: String,
    val dateStart: String,
    val dateEnd: String,
    val gender: String,
    @SerializedName("description_source")val descriptionSource: String,
    val category: String,
    val image: String
)
