package com.example.data.feature.order.di

import com.example.data.feature.order.OrderRepositoryImpl
import com.example.data.feature.order.datasource.OrderApiService
import com.example.domain.ui.feature.order.repository.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class OrderModule {

    @Provides
    @Singleton
    fun provideOrderApiService(retrofit: Retrofit): OrderApiService =
        retrofit.create(OrderApiService::class.java)

    @Provides
    @Singleton
    fun provideOrderRepository(
        apiService: OrderApiService
    ): OrderRepository = OrderRepositoryImpl(apiService)
}