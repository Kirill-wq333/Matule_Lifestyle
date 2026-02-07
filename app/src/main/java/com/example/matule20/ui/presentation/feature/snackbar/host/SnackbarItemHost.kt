package com.example.matule20.ui.presentation.feature.snackbar.host

import com.example.data.feature.error.Error400
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SnackbarItemHost {

    private val _currentSnackbarItem: MutableStateFlow<Error400?> = MutableStateFlow(null)
    val currentSnackbarItem = _currentSnackbarItem.asStateFlow()

    fun setSnackbar(snackbarItem: Error400?) {
        _currentSnackbarItem.update { snackbarItem }
    }

}