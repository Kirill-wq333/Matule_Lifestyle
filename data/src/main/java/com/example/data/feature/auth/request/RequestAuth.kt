package com.example.data.feature.auth.request
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
