package com.example.data.feature.news

import com.example.data.feature.news.datasource.NewsApiService
import com.example.data.feature.news.dto.NewsDto.Companion.toNews
import com.example.domain.ui.feature.news.model.News
import com.example.domain.ui.feature.news.repository.NewsRepository

class NewsRepositoryImpl(
    private val apiService: NewsApiService
) : NewsRepository {

    override suspend fun getNews(): Result<List<News>> = runCatching {
        val response = apiService.getNews()
        Result.success(response.items.map { it.toNews() })
    }.fold(
        onFailure = { Result.failure(it)},
        onSuccess = { it }
    )

}