package com.example.datalib.api.project.datasource

import com.example.datalib.api.project.dto.ProjectDto
import com.example.datalib.api.project.dto.request.RequestProject
import com.example.datalib.api.project.dto.response.ResponseProject
import retrofit2.http.Body
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
//    @WithAuthorization
    @POST("collections/project/records")
    suspend fun postProject(@Body request: RequestProject): ProjectDto

    /**
     *
     * Запрос на получение проектов
     *
     * @return Ответ на получение проектов пользователя
     */
//    @WithAuthorization
    @GET("collections/project/records")
    suspend fun getProjects(): ResponseProject

}