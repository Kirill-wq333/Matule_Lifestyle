package com.example.data.feature.profile.request
/**
 *
 * Запрос на обновление данных пользователя
 *
 * @property email Почта пользователя
 * @property emailVisibility Флаг видимости email для пользователя
 * @property firstname Имя пользователя
 * @property lastname Фамилия пользователя
 * @property secondname Отчество пользователя
 * @property datebirthday Дата рождения пользователя
 * @property gender Пол пользователя
 */
data class RequestUser(
    val email: String,
    val emailVisibility: Boolean,
    val firstname: String,
    val lastname: String,
    val secondname: String,
    val datebirthday: String,
    val gender: String
)