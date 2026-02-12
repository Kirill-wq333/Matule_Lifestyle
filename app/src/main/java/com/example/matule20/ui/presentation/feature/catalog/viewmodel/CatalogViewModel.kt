package com.example.matule20.ui.presentation.feature.catalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.product.interactor.ProductInteractor
import com.example.domain.ui.feature.product.model.Products
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val productInteractor: ProductInteractor
) : ViewModel() {
    private val _products: MutableStateFlow<List<Products>> = MutableStateFlow(listOf())
    val products = _products.asStateFlow()

    init {
        content()
    }

    fun content(){
        viewModelScope.launch {
            val resultProduct = productInteractor.products()

            resultProduct
                .onSuccess { products ->
                    _products.emit(products)
                }
        }
    }
}