package com.example.data.feature.profile.datasource

import com.example.data.feature.profile.dto.UserDto
import com.example.data.feature.profile.dto.request.RequestUser
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

/**
 *
 * Сервис на получение и обновление пользователя
 *
 */
interface ProfileApiService {
    /**
     *
     * Запрос на получение данных пользователя
     *
     * @param id Индификатор на получение пользователя
     * @return Ответ на получение пользователя
     */
    @WithAuthorization
    @GET("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun getUser(@Path("id_user")id: Int): UserDto

    /**
     *
     * Запрос на обновление данных пользователя
     *
     * @param id Индификатор для того чтобы обновить данные
     * @param request Данные для обновления пользователя
     * @return Ответ на получение обновленных данных пользователя
     */
    @WithAuthorization
    @PATCH("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun patchUser(@Path("id_user")id: Int, request: RequestUser): UserDto

}