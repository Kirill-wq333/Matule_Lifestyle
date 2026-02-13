package com.example.data.feature.auth.dto.response

import com.example.data.feature.profile.dto.UserDto
import com.example.data.feature.profile.dto.UserDto.Companion.toUser
import com.example.domain.ui.feature.auth.model.response.ResponseAuth

/**
 *
 * Ответ на успешную авторизацию
 *
 * @property token токен для аунтификации пользователя на других запросах
 * @property record Данные авторизованного пользователя
 */
data class ResponseAuthDto(
    val token: String,
    val record: UserDto
){
    companion object{
        fun ResponseAuthDto.toResponseAuth(): ResponseAuth =
            ResponseAuth(
                token = token,
                record = record.toUser()
            )
    }
}

