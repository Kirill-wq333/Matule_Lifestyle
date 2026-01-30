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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matule20.ui.presentation.feature.auth.ui.TitleAndSubTitleWithImage
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.input.PasswordTextField

@Preview
@Composable
private fun CreatePasswordPrev() {
    CreatePasswordScreen()
}


@Composable
fun CreatePasswordScreen() {
    Content()
}

@Composable
private fun Content() {

    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

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
            onSavePassword = {},
            repeatPassword = repeatPassword,
            onPasswordChange = { password = it },
            onRepeatPasswordChange = { repeatPassword = it }
        )
    }
}

@Composable
fun CreatePasswordContent(
    password: String,
    onSavePassword: () -> Unit,
    repeatPassword: String,
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
            visibleTrailing = true,
            labelText = stringResource(R.string.new_password),
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordTextField(
            password = repeatPassword,
            onPasswordChange = onRepeatPasswordChange,
            visibleTrailing = true,
            labelText = stringResource(R.string.repeat_the_password),
            errorText = "Пароль не совпадает",
            isError = password != repeatPassword
        )
        Spacer(modifier = Modifier.height(10.dp))
        MatuleButton(
            textBtn = stringResource(R.string.btn_save),
            enable = password == repeatPassword,
            activeBtn = password.isNotEmpty() && repeatPassword.isNotEmpty(),
            unactiveBtn = password.isEmpty() || repeatPassword.isEmpty(),
            onClick = onSavePassword
        )
    }
}