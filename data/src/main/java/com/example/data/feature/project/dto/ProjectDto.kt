package com.example.data.feature.project.dto

import com.example.domain.ui.feature.project.model.Project
import com.google.gson.annotations.SerializedName

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
data class ProjectDto(
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
){
    companion object{
        fun ProjectDto.toProject(): Project =
            Project(
                id = id,
                collectionId = collectionId,
                collectionName = collectionName,
                created = created,
                updated = updated,
                title = title,
                dateStart = dateStart,
                dateEnd = dateEnd,
                gender = gender,
                descriptionSource = descriptionSource,
                category = category,
                image = image,
                userId = userId
            )
    }
}