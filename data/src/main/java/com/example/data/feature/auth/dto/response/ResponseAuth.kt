package com.example.data.feature.auth.dto.response

import com.example.data.feature.profile.dto.UserDto
/**
 *
 * Ответ на успешную авторизацию
 *
 * @property token токен для аунтификации пользователя на других запросах
 * @property record Данные авторизованного пользователя
 */
data class ResponseAuth(
    val token: String,
    val record: UserDto
)

