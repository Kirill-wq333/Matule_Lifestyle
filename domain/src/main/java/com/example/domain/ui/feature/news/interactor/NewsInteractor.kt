package com.example.domain.ui.feature.news.interactor

import com.example.domain.ui.feature.news.model.News
import com.example.domain.ui.feature.news.repository.NewsRepository

class NewsInteractor(
    private val newsRepository: NewsRepository
) {
    suspend fun news(): Result<List<News>>{
        return newsRepository.getNews()
    }
}