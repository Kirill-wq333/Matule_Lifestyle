package com.example.matule20.ui.presentation.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.news.interactor.NewsInteractor
import com.example.domain.ui.feature.news.model.News
import com.example.domain.ui.feature.product.interactor.ProductInteractor
import com.example.domain.ui.feature.product.model.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val newsInteractor: NewsInteractor,
    private val productInteractor: ProductInteractor
) : ViewModel() {

    private val _news: MutableStateFlow<List<News>> = MutableStateFlow(listOf())
    val news = _news.asStateFlow()

    private val _products: MutableStateFlow<List<Products>> = MutableStateFlow(listOf())
    val products = _products.asStateFlow()

    init {
        content()
    }

    fun content(){
        viewModelScope.launch {
            val resultProduct = productInteractor.products()
            val resultNews = newsInteractor.news()

            resultNews
                .onSuccess { news ->
                    _news.emit(news)
                }
            resultProduct
                .onSuccess { products ->
                    _products.emit(products)
                }
        }
    }
}