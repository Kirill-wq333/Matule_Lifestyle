package com.example.data.feature.auth.datasource

import com.example.data.feature.profile.model.User
import com.example.data.feature.auth.request.RequestAuth
import com.example.data.feature.auth.request.RequestRegister
import com.example.data.feature.profile.request.RequestUser
import com.example.data.feature.auth.response.ResponseAuth
import com.example.data.feature.auth.response.ResponseRegister
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApiService {


    @POST(NetworkConfig.Routes.RECORDS)
    suspend fun postRegister(request: RequestRegister): ResponseRegister

    @POST(NetworkConfig.Routes.AUTH)
    suspend fun postAuth(request: RequestAuth): ResponseAuth

    @WithAuthorization
    @GET("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun getUser(@Path("id_user")id: Int): User

    @WithAuthorization
    @PATCH("${NetworkConfig.Routes.RECORDS}/{id_user}")
    suspend fun patchUser(@Path("id_user")id: Int, request: RequestUser): User

    @WithAuthorization
    @DELETE("${NetworkConfig.Routes.AUTH_ORIGINS}/{id_token}")
    suspend fun exitSystem(@Path("id_token") idToken: Int)

}