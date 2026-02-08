package com.example.data.feature.project.di

import com.example.data.feature.project.ProjectRepositoryImpl
import com.example.data.feature.project.datasource.ProjectApiService
import com.example.domain.ui.feature.project.repository.ProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProjectModule {

    @Provides
    @Singleton
    fun provideProjectApiService(retrofit: Retrofit): ProjectApiService =
        retrofit.create(ProjectApiService::class.java)

    @Provides
    @Singleton
    fun provideProjectRepository(
        apiService: ProjectApiService
    ): ProjectRepository = ProjectRepositoryImpl(apiService)
}