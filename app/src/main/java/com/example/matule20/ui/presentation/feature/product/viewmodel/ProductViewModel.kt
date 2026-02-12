package com.example.matule20.ui.presentation.feature.product.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.product.interactor.ProductInteractor
import com.example.domain.ui.feature.product.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productInteractor: ProductInteractor
) : ViewModel() {

    private val _productById: MutableStateFlow<Product> = MutableStateFlow(Product())
    val productById = _productById.asStateFlow()

    fun productById(id: String){
        viewModelScope.launch {
            val result = productInteractor.product(id)
            result.onSuccess { _productById.emit(it) }
        }
    }
}