package com.example.matule20.ui.presentation.feature.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.auth.interactor.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class AuthViewModel(
    private val authInteractor: AuthInteractor
): ViewModel() {
    fun auth(
        identity: String,
        password: String
    ){
        viewModelScope.launch{
            authInteractor.auth(identity,password)
        }
    }
}