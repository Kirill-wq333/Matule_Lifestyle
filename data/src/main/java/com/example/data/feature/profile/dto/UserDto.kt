package com.example.data.feature.profile.dto

import com.example.domain.ui.feature.profile.model.User

/**
 *
 * Модель данных пользователя
 *
 * @property collectionId Идентификатор коллекции/таблицы пользователей в базе данных
 * @property collectionName Название коллекции/таблицы пользователей
 * @property created Дата и время создания записи пользователя
 * @property emailVisibility Флаг видимости email для пользователя
 * @property firstname Имя пользователя
 * @property id Уникальный идентификатор пользователя в системе
 * @property lastname Фамилия пользователя
 * @property secondname Отчество пользователя
 * @property updated Дата и время последнего обновления записи
 * @property verified Флаг подтверждения email адреса пользователя
 * @property datebirthday Дата рождения пользователя
 * @property gender Пол пользователя
 */
data class UserDto(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val emailVisibility: Boolean,
    val firstname: String,
    val id: String,
    val lastname: String,
    val secondname: String,
    val updated: String,
    val verified: String,
    val datebirthday: String,
    val gender: String
){
    companion object{
        fun UserDto.toUser(): User =
            User(
                collectionId = collectionId,
                collectionName = collectionName,
                created = created,
                emailVisibility = emailVisibility,
                firstname = firstname,
                id = id,
                lastname = lastname,
                secondname = secondname,
                updated = updated,
                verified = verified,
                datebirthday = datebirthday,
                gender = gender
            )
    }
}
