package com.example.domain.ui.feature.news.repository

import com.example.domain.ui.feature.news.model.News

interface NewsRepository {

    suspend fun getNews(): Result<List<News>>
}