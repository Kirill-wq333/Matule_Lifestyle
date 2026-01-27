package com.example.data.feature.project.datasource

import com.example.data.feature.project.request.RequestProject
import com.example.data.feature.project.response.Project
import com.example.data.feature.project.response.ResponseProject
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.POST

interface ProjectApiService {

    @WithAuthorization
    @POST(NetworkConfig.Routes.PROJECT)
    suspend fun postProject(request: RequestProject): Project

    @WithAuthorization
    @GET(NetworkConfig.Routes.PROJECT)
    suspend fun getProject(): ResponseProject

}