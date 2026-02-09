package com.example.datalib.api.auth.dto.request
/**
 *
 * Запрос на авторизацию пользователя
 *
 * @property identity логин пользователя
 * @property password Пароль пользователя
 */
data class RequestAuth(
    val identity: String,
    val password: String
)
