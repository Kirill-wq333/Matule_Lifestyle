package com.example.data.feature.error

/**
 *
 * Ответ ошибки
 *
 * @property status Статус ошибки
 * @property message Сообщение об ошибке
 * @property data Список Текстов
 */
data class Error400(
    val status: Int,
    val message: String,
    val data: List<String>
)
