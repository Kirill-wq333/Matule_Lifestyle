package com.example.matule20.ui.presentation.feature.createPassword.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.auth.ui.TitleAndSubTitleWithImage
import com.example.matule20.ui.presentation.feature.auth.ui.validatePassword
import com.example.matule20.ui.presentation.feature.register.viewmodel.RegisterUiState
import com.example.matule20.ui.presentation.feature.register.viewmodel.RegisterViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.input.PasswordTextField


@Composable
fun CreatePasswordScreen(
    vm: RegisterViewModel,
    navController: NavHostController
) {
    Content(
        vm = vm,
        navController = navController
    )
}

@Composable
private fun Content(
    vm: RegisterViewModel,
    navController: NavHostController
) {
    val email = remember {
        navController.currentBackStackEntry?.arguments?.getString("email") ?:
        navController.previousBackStackEntry?.arguments?.getString("email") ?: ""
    }

    val uiState by vm.registerUiState.collectAsStateWithLifecycle()
    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var repeatPasswordError by remember { mutableStateOf("") }
    var isSubmit by remember { mutableStateOf(false) }

    LaunchedEffect(uiState) {
        when(uiState){
            is RegisterUiState.Success -> {
                navController.navigate(AppRoutes.CREATE_SECURE_CODE_PASSWORD){
                    popUpTo(AppRoutes.CREATE_NEW_PASSWORD){ inclusive = true }
                }
            }
            is RegisterUiState.Error -> {
                val error = uiState as RegisterUiState.Error
               repeatPasswordError = error.message
            }
            else -> Unit
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 59.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(90.dp)
    ) {
        TitleAndSubTitleWithImage(
            title = R.string.creating_password,
            subTitle = R.string.enter_new_password
        )
        CreatePasswordContent(
            password = password,
            onSavePassword = {
                isSubmit = true
                passwordError = if (password.isEmpty()) {
                    "Введите пароль"
                } else {
                    validatePassword(password) ?: ""
                }
                repeatPasswordError = if (repeatPassword.isEmpty()) {
                    "Введите пароль"
                } else {
                    validateRepeatPassword(
                        password = password,
                        repeatPassword = repeatPassword,
                    ) ?: ""
                }
                if (passwordError.isEmpty() && repeatPasswordError.isEmpty()){
                    vm.register(email,password,repeatPassword)
                }
            },
            repeatPassword = repeatPassword,
            onPasswordChange = {
                password = it
                if (isSubmit) {
                    passwordError = if (it.isEmpty()) {
                        "Введите пароль"
                    } else {
                        validatePassword(it) ?: ""
                    }
                    repeatPasswordError = validateRepeatPassword(it, repeatPassword) ?: ""
                } else {
                    passwordError = ""
                }
            },
            repeatPasswordError = repeatPasswordError,
            passwordError = passwordError,
            onRepeatPasswordChange = {
                repeatPassword = it
                repeatPasswordError = if (isSubmit) {
                    if (it.isEmpty()) {
                        "Повторите пароль"
                    } else {
                        validateRepeatPassword(password, it) ?: ""
                    }
                } else {
                    ""
                }
            }
        )
    }
}

@Composable
fun CreatePasswordContent(
    password: String,
    onSavePassword: () -> Unit,
    repeatPassword: String,
    repeatPasswordError: String,
    passwordError: String,
    onPasswordChange: (String) -> Unit,
    onRepeatPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PasswordTextField(
            password = password,
            onPasswordChange = onPasswordChange,
            errorText = passwordError,
            isError = passwordError.isNotEmpty(),
            visibleTrailing = true,
            labelText = stringResource(R.string.new_password),
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordTextField(
            password = repeatPassword,
            onPasswordChange = onRepeatPasswordChange,
            visibleTrailing = true,
            labelText = stringResource(R.string.repeat_the_password),
            errorText = repeatPasswordError,
            isError = repeatPasswordError.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(10.dp))
        MatuleButton(
            textBtn = stringResource(R.string.btn_save),
            enable = password.isNotEmpty() && repeatPassword.isNotEmpty(),
            activeBtn = password.isNotEmpty() && repeatPassword.isNotEmpty(),
            unactiveBtn = password.isEmpty() || repeatPassword.isEmpty(),
            onClick = onSavePassword
        )
    }
}


fun validateRepeatPassword(password: String, repeatPassword: String): String? {
    val errors = mutableListOf<String>()

    if (repeatPassword.isEmpty()) {
        errors.add("Повторите пароль")
    } else if (repeatPassword != password) {
        errors.add("Пароли не совпадают")
    }

    return if (errors.isNotEmpty()) errors.joinToString("\n") else null
}