package com.example.datalib.api.news.datasource

import com.example.datalib.api.news.dto.response.ResponseNews
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
//    @WithAuthorization
    @GET("collections/news/records")
    suspend fun getNews(): ResponseNews

}