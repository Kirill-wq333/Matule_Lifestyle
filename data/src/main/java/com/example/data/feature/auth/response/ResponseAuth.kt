package com.example.data.feature.auth.response

import com.example.data.feature.profile.model.User

/**
 *
 * Ответ на успешную авторизацию
 *
 * @property token токен для аунтификации пользователя на других запросах
 * @property record Данные авторизованного пользователя
 */
data class ResponseAuth(
    val token: String,
    val record: User
)

