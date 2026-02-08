package com.example.data.feature.product.di

import com.example.data.feature.product.ProductRepositoryImpl
import com.example.data.feature.product.datasource.ProductApiService
import com.example.domain.ui.feature.product.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProductModule {
    @Provides
    @Singleton
    fun provideProductApiService(retrofit: Retrofit): ProductApiService =
        retrofit.create(ProductApiService::class.java)

    @Provides
    @Singleton
    fun provideProductRepository(
        apiService: ProductApiService
    ): ProductRepository = ProductRepositoryImpl(apiService)
}