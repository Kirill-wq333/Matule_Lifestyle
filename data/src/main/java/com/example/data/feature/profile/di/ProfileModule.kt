package com.example.data.feature.profile.di

import com.example.data.feature.profile.ProfileRepositoryImpl
import com.example.data.feature.profile.datasource.ProfileApiService
import com.example.data.feature.project.datasource.ProjectApiService
import com.example.domain.ui.feature.profile.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    @Provides
    @Singleton
    fun provideProfileApiService(retrofit: Retrofit): ProjectApiService =
        retrofit.create(ProjectApiService::class.java)

    @Provides
    @Singleton
    fun provideProfileRepository(
        apiService: ProfileApiService
    ): ProfileRepository = ProfileRepositoryImpl(apiService)
}