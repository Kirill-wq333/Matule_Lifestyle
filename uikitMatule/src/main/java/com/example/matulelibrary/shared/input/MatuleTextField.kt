package com.example.matulelibrary.shared.input

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.typography.MatuleTypography

/**
 *
 * Поле поиска с иконкой лупы.
 *
 * @param search Отображаемый текст в строке
 * @param modifier Модификатор для настройки внешнего вида и поведения
 * @param onSearchChange Лямбда-функция, позваоляющая писать текст
 * @param clearSearch Лямбда-функция, которая очищает текст в строке
 */
@Composable
fun SearchTextField(
    search: String,
    modifier: Modifier = Modifier,
    onSearchChange: (String) -> Unit,
    clearSearch: () -> Unit
) {
    MatuleTextField(
        text = search,
        modifier = modifier,
        onTextChange = onSearchChange,
        trailingIcon = {
            if (search.isNotEmpty()) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = clearSearch)
                )
            }
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_search),
                contentDescription = null,
            )
        }
    )
}

/**
 *
 * Поле для ввода пароля с переключением видимости.
 *
 * @param password Отображаемый пароль в строке
 * @param onPasswordChange Лямбда-функция, позваоляющая писать текст
 * @param visibleTrailing Состояние видимости последней иконки
 * @param labelText Название строки
 * @param errorText Текст ошибки
 * @param isError Отображение ошибки
 */
@Composable
fun PasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    visibleTrailing: Boolean = false,
    labelText: String = "",
    errorText: String = "",
    isError: Boolean = false
) {
    var visiblePassword by remember { mutableStateOf(false) }

    val transformation = if (visiblePassword) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation('*')
    }


    val trailingIcon = if(visiblePassword) R.drawable.ic_eye else R.drawable.ic_close_eye

    MatuleTextField(
        text = password,
        onTextChange = onPasswordChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = transformation,
        labelText = labelText,
        errorText = errorText,
        isError = isError,
        label = true,
        trailingIcon = {
            if (visibleTrailing) {
                Icon(
                    imageVector = ImageVector.vectorResource(trailingIcon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .clickable {
                            visiblePassword = !visiblePassword
                        }
                )
            }
        }
    )
}

/**
 *
 * Кастомное текстовое поле с поддержкой различных состояний и визуальных элементов.
 *
 * @param text Текущее значение текстового поля
 * @param onTextChange Callback при изменении текста
 * @param modifier Модификатор для настройки расположения и размера контейнера
 * @param placeholder Текст-подсказка, отображаемый когда поле пустое
 * @param errorText Текст ошибки, отображаемый при isError = true
 * @param labelText Текст метки, отображаемый над полем
 * @param keyboardOptions Настройки клавиатуры
 * @param label Флаг отображения метки над полем
 * @param isError Флаг состояния ошибки
 * @param textStyle Стиль основного текста в поле
 * @param visualTransformation Преобразование отображения текста
 * @param placeholderStyle Стиль текста плейсхолдера
 * @param leadingIcon Компонент иконки в начале поля
 * @param trailingIcon Компонент иконки в конце поля
 */
@Composable
fun MatuleTextField(
    text: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    errorText: String = "",
    labelText: String = "",
    onTextChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    label: Boolean = false,
    isError: Boolean = false,
    textStyle: TextStyle = MatuleTypography.textRegular15,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholderStyle: TextStyle = MatuleTypography.textRegular15,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        if (label){
            Text(
                text = labelText,
                color = MatuleColors.description,
                style = MatuleTypography.captionRegular14
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (isError) MatuleColors.error
                    else if (text.isNotEmpty() && !isFocused) Color(0xFFB8C1CC)
                    else if (isFocused) MatuleColors.accent.copy(0.5f)
                    else MatuleColors.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            TextField(
                value = text,
                onValueChange = onTextChange,
                trailingIcon = trailingIcon,
                leadingIcon = leadingIcon,
                keyboardOptions = keyboardOptions,
                isError = isError,
                visualTransformation = visualTransformation,
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = MatuleColors.inputBg,
                    focusedPlaceholderColor = Color(0xFF939396),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = MatuleColors.inputBg,
                    cursorColor = MatuleColors.accent,
                    errorTextColor = MatuleColors.error,
                    errorCursorColor = MatuleColors.error,
                    errorIndicatorColor = Color.Transparent,
                    errorContainerColor = MatuleColors.error.copy(0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                textStyle = textStyle,
                singleLine = true,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color(0xFF939396),
                        style = placeholderStyle
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    }
                    .focusRequester(focusRequester)
            )
        }
        if (isError) {
            Text(
                text = errorText,
                color = MatuleColors.error,
                style = MatuleTypography.captionRegular14
            )
        }
    }
}