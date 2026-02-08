package com.example.data.feature.news.datasource

import com.example.data.feature.news.dto.response.ResponseNews
import com.example.data.network.annotation.WithAuthorization
import com.example.data.network.config.NetworkConfig
import retrofit2.http.GET

/**
 *
 * Сервис на получение новостей и акций для пользователя
 *
 */
interface NewsApiService {
    /**
     *
     * Запрос на получение "Новостей и акций"
     *
     * @return Ответ с данными "Новостей и акций"
     */
    @WithAuthorization
    @GET(NetworkConfig.Routes.PROMOTIONS_NEWS)
    suspend fun getNews(): ResponseNews

}