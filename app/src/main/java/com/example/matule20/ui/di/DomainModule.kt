package com.example.matule20.ui.di

import com.example.domain.ui.feature.auth.interactor.AuthInteractor
import com.example.domain.ui.feature.auth.repository.AuthRepository
import com.example.domain.ui.feature.cart.interactor.CartInteractor
import com.example.domain.ui.feature.cart.repository.CartRepository
import com.example.domain.ui.feature.news.interactor.NewsInteractor
import com.example.domain.ui.feature.news.repository.NewsRepository
import com.example.domain.ui.feature.order.interactor.OrderInteractor
import com.example.domain.ui.feature.order.repository.OrderRepository
import com.example.domain.ui.feature.product.interactor.ProductInteractor
import com.example.domain.ui.feature.product.repository.ProductRepository
import com.example.domain.ui.feature.profile.interactor.ProfileInteractor
import com.example.domain.ui.feature.profile.repository.ProfileRepository
import com.example.domain.ui.feature.project.interactor.ProjectInteractor
import com.example.domain.ui.feature.project.repository.ProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    @Singleton
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor =
        AuthInteractor(authRepository)

    @Provides
    @Singleton
    fun provideCartInteractor(cartRepository: CartRepository): CartInteractor =
        CartInteractor(cartRepository)

    @Provides
    @Singleton
    fun provideNewsInteractor(newsRepository: NewsRepository): NewsInteractor =
        NewsInteractor(newsRepository)

    @Provides
    @Singleton
    fun provideOrderInteractor(orderRepository: OrderRepository): OrderInteractor =
        OrderInteractor(orderRepository)

    @Provides
    @Singleton
    fun provideProductInteractor(productRepository: ProductRepository): ProductInteractor =
        ProductInteractor(productRepository)

    @Provides
    @Singleton
    fun provideProfileInteractor(profileRepository: ProfileRepository): ProfileInteractor =
        ProfileInteractor(profileRepository)

    @Provides
    @Singleton
    fun provideProjectInteractor(projectRepository: ProjectRepository): ProjectInteractor =
        ProjectInteractor(projectRepository)
}