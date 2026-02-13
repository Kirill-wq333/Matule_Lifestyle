package com.example.matule20.ui.presentation.feature.register.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.storage.token.TokenProvider
import com.example.domain.ui.feature.auth.interactor.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _registerUiState: MutableStateFlow<RegisterUiState> = MutableStateFlow(RegisterUiState.Idle)
    val registerUiState = _registerUiState.asStateFlow()

    fun register(email: String, password: String, passwordConfirm: String) {
        viewModelScope.launch {
            val result = authInteractor.register(email = email, password = password, passwordConfirm = passwordConfirm)
            result
                .onSuccess {
                    _registerUiState.value = RegisterUiState.Success
                }
                .onFailure { error ->
                    _registerUiState.value = RegisterUiState.Error(error.message ?: "Неизвестная ошибка")
                }
        }
    }
}

sealed interface RegisterUiState{
    object Idle : RegisterUiState
    object Success : RegisterUiState
    data class Error(val message: String) : RegisterUiState
}