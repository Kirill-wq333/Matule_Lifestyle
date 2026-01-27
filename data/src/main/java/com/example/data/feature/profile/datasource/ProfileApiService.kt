package com.example.data.feature.profile.datasource

import com.example.data.feature.profile.model.User
import com.example.data.feature.profile.request.RequestUser
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ProfileApiService {

    @WithAuthorization
    @GET("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun getUser(@Path("id_user")id: Int): User

    @WithAuthorization
    @PATCH("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun patchUser(@Path("id_user")id: Int, request: RequestUser): User

}