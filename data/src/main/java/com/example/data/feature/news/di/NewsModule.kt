package com.example.data.feature.news.di

import com.example.data.feature.news.NewsRepositoryImpl
import com.example.data.feature.news.datasource.NewsApiService
import com.example.domain.ui.feature.news.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(
        apiService: NewsApiService
    ): NewsRepository = NewsRepositoryImpl(apiService)
}