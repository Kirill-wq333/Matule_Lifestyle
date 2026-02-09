package com.example.datalib.client

import com.example.datalib.api.auth.datasource.AuthApiService
import com.example.datalib.api.cart.datasource.CartApiService
import com.example.datalib.api.news.datasource.NewsApiService
import com.example.datalib.api.order.datasource.OrderApiService
import com.example.datalib.api.product.datasource.ProductApiService
import com.example.datalib.api.profile.datasource.ProfileApiService
import com.example.datalib.api.project.datasource.ProjectApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitStorage {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://103.90.75.40:8787/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val authClient: AuthApiService by lazy { retrofit.create(AuthApiService::class.java) }
    val cartClient: CartApiService by lazy { retrofit.create(CartApiService::class.java) }
    val newsClient: NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
    val orderClient: OrderApiService by lazy { retrofit.create(OrderApiService::class.java) }
    val productClient: ProductApiService by lazy { retrofit.create(ProductApiService::class.java) }
    val profileClient: ProfileApiService by lazy { retrofit.create(ProfileApiService::class.java) }
    val projectClient: ProjectApiService by lazy { retrofit.create(ProjectApiService::class.java) }
}