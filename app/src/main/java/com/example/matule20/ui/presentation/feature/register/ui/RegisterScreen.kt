package com.example.matule20.ui.presentation.feature.register.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.input.MatuleTextField
import com.example.matulelibrary.shared.selection.Selection
import com.example.matulelibrary.typography.MatuleTypography

@Preview
@Composable
private fun RegisterPrev() {
    RegisterScreen(navController = rememberNavController())
}

@Composable
fun RegisterScreen(
    navController: NavHostController
) {
    Content(navController = navController)
}

@Composable
private fun Content(
    navController: NavHostController
) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var patronymic by remember { mutableStateOf("") }
    var dateBirthday by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }

    var isSubmitted by remember { mutableStateOf(false) }
    val activeBtn = firstName.isNotEmpty() && lastName.isNotEmpty() && patronymic.isNotEmpty() && mail.isNotEmpty() && dateBirthday.isNotEmpty()
    val unActiveBtn = firstName.isEmpty() || lastName.isEmpty() || patronymic.isEmpty() || mail.isEmpty() || dateBirthday.isEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.White)
            .padding(horizontal = 20.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            RegisterTitleAndSubTitles()
            Spacer(modifier = Modifier.height(32.dp))
            RegisterContent(
                firstName = firstName,
                lastName = lastName,
                patronymic = patronymic,
                dateBirthday = dateBirthday,
                mail = mail,
                gender = "",
                onFirstNameChange = { firstName = it },
                onLastNameChange = { lastName = it },
                onPatronymicChange = { patronymic = it },
                onDateBirthdayChange = { dateBirthday = it },
                onMailChange = { mail = it },
                isSubmitted = isSubmitted
            )
        }

        MatuleButton(
            textBtn = stringResource(R.string.btn_next),
            activeBtn = activeBtn,
            unactiveBtn = unActiveBtn,
            enable = activeBtn,
            onClick = {
                isSubmitted = true
                navController.navigate(AppRoutes.CREATE_NEW_PASSWORD)
            }
        )
    }
}

@Composable
private fun RegisterContent(
    firstName: String,
    lastName: String,
    patronymic: String,
    dateBirthday: String,
    mail: String,
    isSubmitted: Boolean,
    gender: String,
    onFirstNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onPatronymicChange: (String) -> Unit,
    onDateBirthdayChange: (String) -> Unit,
    onMailChange: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        MatuleTextField(
            text = firstName,
            errorText = "Это поле обязательно!",
            isError = firstName.isEmpty() && isSubmitted,
            placeholder = "Имя",
            onTextChange = onFirstNameChange
        )
        MatuleTextField(
            text = patronymic,
            errorText = "Это поле обязательно!",
            isError = patronymic.isEmpty() && isSubmitted,
            placeholder = "Отчество",
            onTextChange = onPatronymicChange
        )
        MatuleTextField(
            text = lastName,
            errorText = "Это поле обязательно!",
            isError = lastName.isEmpty() && isSubmitted,
            placeholder = "Фамилия",
            onTextChange = onLastNameChange
        )
        MatuleTextField(
            text = dateBirthday,
            errorText = "Это поле обязательно!",
            isError = dateBirthday.isEmpty() && isSubmitted,
            placeholder = "Дата рождения",
            onTextChange = onDateBirthdayChange
        )
        Selection(
            image = R.drawable.palm,
            selectionName = gender.ifEmpty { "Пол" },
            visibleColorActive = false
        )
        MatuleTextField(
            text = mail,
            errorText = "Это поле обязательно!",
            isError = mail.isEmpty() && isSubmitted,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = "Почта",
            onTextChange = onMailChange
        )
    }
}

@Composable
fun RegisterTitleAndSubTitles() {
    Column() {
        Text(
            text = stringResource(R.string.creating_a_profile),
            color = Color.Black,
            style = MatuleTypography.titleExtraBold24
        )
        Spacer(modifier = Modifier.height(44.dp))
        Text(
            text = stringResource(R.string.register_description1),
            color = Color(0xFF939396),
            style = MatuleTypography.captionRegular14
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.register_description2),
            color = Color(0xFF939396),
            style = MatuleTypography.captionRegular14
        )

    }
}