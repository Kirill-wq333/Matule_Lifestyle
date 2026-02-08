package com.example.matule20.ui.presentation.feature.auth.ui

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.auth.viewmodel.AuthViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.shared.button.LogInButton
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.input.MatuleTextField
import com.example.matulelibrary.shared.input.PasswordTextField
import com.example.matulelibrary.spacers.MatuleSpacers
import com.example.matulelibrary.typography.MatuleTypography


@Composable
fun AuthScreen(
    vm: AuthViewModel,
    navController: NavHostController
) {
    Content(
        vm = vm,
        navController = navController
    )
}

@Composable
private fun Content(
    vm: AuthViewModel,
    navController: NavHostController
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    var isSubmitted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
            )
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 59.dp,
                bottom = 56.dp
            )
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AuthContent(
            email = email,
            password = password,
            onEmailChange = {
                email = it.lowercase()
                emailError = ""
            },
            emailError = if (isSubmitted) emailError else "",
            passwordError = if (isSubmitted) passwordError else "",
            onPasswordChange = {
                password = it
                passwordError = ""
            },
            openProfileScreen = {
                isSubmitted = true

                emailError = if (email.isEmpty()) {
                    "Введите email"
                } else if (!validateEmail(email)) {
                    "Формат: name@domain.ru только маленькие буквы и цифры"
                } else {
                    ""
                }

                passwordError = if (password.isEmpty()) {
                    "Введите пароль"
                } else {
                    validatePassword(password) ?: ""
                }

                if(emailError.isEmpty() && passwordError.isEmpty()){
                    vm.auth(email, password)
                    navController.navigate(AppRoutes.PROFILE)
                }
            },
            openRegisterScreen = {
                navController.navigate(AppRoutes.REGISTER)
            }
        )
        ActionsAuth(
            onVkClick = {},
            onYandexClick = {}
        )
    }
}


@Composable
private fun AuthContent(
    email: String,
    password: String,
    emailError: String,
    passwordError: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    openProfileScreen: () -> Unit,
    openRegisterScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleAndSubTitleWithImage(
            title = R.string.welcome,
            subTitle  = R.string.auth_descriptions
        )
        Spacer(modifier = Modifier.height(64.dp))
        MatuleTextField(
            text = email,
            placeholder = "example@mail.com",
            onTextChange = onEmailChange,
            errorText = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = emailError.isNotEmpty(),
            label = true,
            labelText = stringResource(R.string.log_in_email)
        )
        Spacer(modifier = Modifier.height(14.dp))
        PasswordTextField(
            password = password,
            errorText = passwordError,
            isError = passwordError.isNotEmpty(),
            onPasswordChange = onPasswordChange,
            labelText = stringResource(R.string.password),
            visibleTrailing = password.isNotEmpty()
        )
        Spacer(modifier = Modifier.height(14.dp))
        MatuleButton(
            textBtn = stringResource(R.string.btn_next),
            activeBtn = password.isNotEmpty() && email.isNotEmpty(),
            unactiveBtn = password.isEmpty() || email.isEmpty(),
            onClick = openProfileScreen
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.btn_register),
            color = MatuleColors.accent,
            style = MatuleTypography.textRegular15,
            modifier = Modifier.clickable(
                onClick = openRegisterScreen
            )
        )
    }
}

@Composable
private fun ActionsAuth(
    onVkClick: () -> Unit,
    onYandexClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.or_log_in_in_using),
            color = Color(0xFF939396),
            style = MatuleTypography.textRegular15
        )
        Spacer(modifier = Modifier.height(16.dp))
        LogInButton(
            text = stringResource(R.string.log_in_vk),
            onClick = onVkClick,
            icon = R.drawable.ic_vk_logo
        )
        Spacer(modifier = Modifier.height(16.dp))
        LogInButton(
            text = stringResource(R.string.log_in_yandex),
            onClick = onYandexClick,
            icon = R.drawable.ic_yandex_logo
        )
    }
}

@Composable
fun TitleAndSubTitleWithImage(
    title: Int,
    subTitle: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(23.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MatuleSpacers.spacer16)
        ) {
            Image(
                painter = painterResource(R.drawable.palm),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
            Text(
                text = stringResource(title),
                color = Color.Black,
                style = MatuleTypography.titleExtraBold24
            )
        }
        Text(
            text = stringResource(subTitle),
            color = Color.Black,
            style = MatuleTypography.textRegular15
        )
    }
}

fun validateEmail(email: String): Boolean {
    val emailPattern = Patterns.EMAIL_ADDRESS.matcher(email)
    return emailPattern.matches()
}

fun validatePassword(password: String): String? {
    val errors = mutableListOf<String>()

    if (password.length < 8) {
        errors.add("Не менее 8 символов")
    }
    if (!password.any { it.isDigit() }) {
        errors.add("Минимум 1 цифра")
    }
    if (!password.any { it.isLowerCase() }) {
        errors.add("Минимум 1 маленькая буква")
    }
    if (!password.any { it.isUpperCase() }) {
        errors.add("Минимум 1 заглавная буква")
    }
    if (!password.any { !it.isLetterOrDigit() }) {
        errors.add("Минимум 1 спецсимвол (!@#\$%^&*)")
    }

    return if (errors.isNotEmpty()) errors.joinToString("\n") else null
}
