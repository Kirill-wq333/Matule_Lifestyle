package com.example.data.feature.news.datasource

import com.example.data.feature.news.response.ResponseNews
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET

interface NewsApiService {

    @WithAuthorization
    @GET(NetworkConfig.Routes.PROMOTIONS_NEWS)
    suspend fun getNews(): ResponseNews

}