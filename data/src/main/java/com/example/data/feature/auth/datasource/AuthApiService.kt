package com.example.data.feature.auth.datasource

import com.example.data.feature.auth.request.RequestAuth
import com.example.data.feature.auth.request.RequestRegister
import com.example.data.feature.auth.response.ResponseAuth
import com.example.data.feature.auth.response.ResponseRegister
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
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
    @POST(NetworkConfig.Routes.RECORDS)
    suspend fun postRegister(request: RequestRegister): ResponseRegister

    /**
     *
     * Вход существующего пользователя в систему
     *
     * @param request Данные для входа
     * @return Ответ с токеном и данными пользователя
     */
    @POST(NetworkConfig.Routes.AUTH)
    suspend fun postAuth(request: RequestAuth): ResponseAuth

    /**
     *
     * Выход из системы
     *
     * @param idToken Токен пользователя для выхода
     */
    @WithAuthorization
    @DELETE("${NetworkConfig.Routes.AUTH_ORIGINS}/{id_token}")
    suspend fun exitSystem(@Path("id_token") idToken: Int)

}