package com.example.matulelibrary.shared.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.iconbtn.SmallIconButton
import com.example.matulelibrary.typography.MatuleTypography

/**
 *
 * Хеадер, состоящий из 2-х состояний
 *
 * @param isCart Состояние хеадера при true - в корзине, а при false - на других экранах
 * @param visibleSmallIcon Отображение кнопки, возвращающая на предыдущий экран
 * @param onBack Лямбда-функция, которая возращяет на предыдущий экран
 * @param headerText Название экрана
 * @param endIcon Последняя иконка, которая отображается через ресурсы .xml
 * @param visibleEndIcon Отображение правой иконки для других функций
 */
@Composable
fun MatuleHeader(
    modifier: Modifier = Modifier,
    isCart: Boolean = false,
    visibleSmallIcon: Boolean = false,
    onBack: () -> Unit = {},
    headerText: String,
    endIcon: Int = R.drawable.ic_plus,
    visibleEndIcon: Boolean = false
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (visibleSmallIcon) {
                SmallIconButton(
                    icon = R.drawable.ic_chevron_left,
                    onClick = onBack,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                )
            }
            if (!isCart) {
                Text(
                    text = headerText,
                    color = Color.Black,
                    style = MatuleTypography.titleSemibold20,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                if (visibleEndIcon) {
                    Icon(
                        imageVector = ImageVector.vectorResource(endIcon),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
        }

        if (isCart){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.cart),
                    color = Color.Black,
                    style = MatuleTypography.titleExtraBold24
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_delete),
                    contentDescription = null,
                    tint = Color(0xFFB8C1CC)
                )
            }
        }
    }
}