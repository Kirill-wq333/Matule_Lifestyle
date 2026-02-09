package com.example.datalib.api.auth.datasource

import com.example.datalib.api.auth.dto.request.RequestAuth
import com.example.datalib.api.auth.dto.request.RequestRegister
import com.example.datalib.api.auth.dto.response.ResponseAuth
import com.example.datalib.api.auth.dto.response.ResponseRegister
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Сервис для работы с аутентификацией и управлением пользователями.
 * Предоставляет методы для регистрации, авторизации и управления профилем пользователя.
 */
interface AuthApiService {

    /**
     *
     * Регистрация нового пользователя в системе
     *
     * @param request Данные для регистрации нового пользователя
     * @return Ответ с данными зарегистрированного пользователя
     */
    @POST("collections/users/records")
    suspend fun postRegister(@Body request: RequestRegister): ResponseRegister

    /**
     *
     * Вход существующего пользователя в систему
     *
     * @param request Данные для входа
     * @return Ответ с токеном и данными пользователя
     */
    @POST("collections/users/auth-with-password")
    suspend fun postAuth(@Body request: RequestAuth): ResponseAuth

    /**
     *
     * Выход из системы
     *
     * @param idToken Токен пользователя для выхода
     */
//    @WithAuthorization
    @DELETE("/collections/_authOrigins/records/{id_token}")
    suspend fun exitSystem(@Path("id_token") idToken: Int)

}