package com.example.matule20.ui.presentation.feature.cart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.cart.interactor.CartInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartInteractor: CartInteractor
) : ViewModel() {

    fun postCart(){
        viewModelScope.launch {
            val result = cartInteractor.postCart(
                userId = "",
                productId = "",
                count = 0
            )
        }
    }
}