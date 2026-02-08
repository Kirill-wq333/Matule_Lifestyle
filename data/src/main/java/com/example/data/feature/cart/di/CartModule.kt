package com.example.data.feature.cart.di

import com.example.data.feature.cart.CartRepositoryImpl
import com.example.data.feature.cart.datasource.CartApiService
import com.example.domain.ui.feature.cart.repository.CartRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CartModule {

    @Provides
    @Singleton
    fun provideCartApiService(retrofit: Retrofit): CartApiService =
        retrofit.create(CartApiService::class.java)

    @Provides
    @Singleton
    fun provideCartRepository(
        apiService: CartApiService
    ): CartRepository = CartRepositoryImpl(apiService)
}