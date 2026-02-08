package com.example.data.feature.auth.di

import com.example.data.feature.auth.AuthRepositoryImpl
import com.example.data.feature.auth.datasource.AuthApiService
import com.example.domain.ui.feature.auth.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AuthModule {

    @Provides
    @Singleton
    fun provideAuthApiService(retrofit: Retrofit): AuthApiService =
        retrofit.create(AuthApiService::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(
        apiService: AuthApiService
    ) : AuthRepository = AuthRepositoryImpl(apiService)

}