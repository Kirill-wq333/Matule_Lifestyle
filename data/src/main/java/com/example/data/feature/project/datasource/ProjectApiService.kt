package com.example.data.feature.project.datasource

import com.example.data.feature.project.request.RequestProject
import com.example.data.feature.project.response.Project
import com.example.data.feature.project.response.ResponseProject
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *
 * Сервис на получение проектов и добавление проекта
 *
 */
interface ProjectApiService {
    /**
     *
     * Запрос на добавление проекта
     *
     * @param request Данные которые создают проект
     * @return Ответ на создание проекта
     */
    @WithAuthorization
    @POST(NetworkConfig.Routes.PROJECT)
    suspend fun postProject(request: RequestProject): Project

    /**
     *
     * Запрос на получение проектов
     *
     * @return Ответ на получение проектов пользователя
     */
    @WithAuthorization
    @GET(NetworkConfig.Routes.PROJECT)
    suspend fun getProject(): ResponseProject

}