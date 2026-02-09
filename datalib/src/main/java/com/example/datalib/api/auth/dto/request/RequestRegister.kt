package com.example.datalib.api.auth.dto.request
/**
 *
 * Запрос для регистрации по почте и паролю
 *
 * @property email Почта пользователя
 * @property password Пароль пользователя
 * @property passwordConfirm Пароль для подтверждения
 */
data class RequestRegister(
    val email: String,
    val password: String,
    val passwordConfirm: String
)