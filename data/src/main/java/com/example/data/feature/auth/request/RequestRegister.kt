package com.example.data.feature.auth.request
/**
 *
 * Запрос для регистрации по почте и паролю
 *
 * @property email Почта пользователя
 * @property password Пароль пользователя
 * @property passwordConFirm Пароль для подтверждения
 */
data class RequestRegister(
    val email: String,
    val password: String,
    val passwordConFirm: String
)