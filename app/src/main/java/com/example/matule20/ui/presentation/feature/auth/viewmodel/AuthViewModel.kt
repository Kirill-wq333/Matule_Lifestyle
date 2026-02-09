package com.example.matule20.ui.presentation.feature.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ui.feature.auth.interactor.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _authState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val authState: StateFlow<AuthUiState> = _authState.asStateFlow()
    fun auth(
        identity: String,
        password: String
    ){
        viewModelScope.launch {
           authInteractor.auth(identity, password)
                .onSuccess {
                    _authState.value = AuthUiState.Success
                }
                .onFailure { error ->
                    _authState.value = AuthUiState.Error(error.message ?: "Неизвестная ошибка")
                }
        }
    }
}

sealed interface AuthUiState{
    object Idle : AuthUiState
    object Success : AuthUiState
    data class Error(val message: String) : AuthUiState
}