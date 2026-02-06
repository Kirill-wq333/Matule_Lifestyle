package com.example.matulelibrary.shared.button

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.spacers.MatuleSpacers
import com.example.matulelibrary.typography.MatuleTypography
/**
 *
 * Универсальная кнопка авторизации через сервисы
 *
 * @param text название серввиса
 * @param icon Иконка серввиса
 * @param onClick Обработчик нажатия кнопки
 */
@Composable
fun LogInButton(
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
        .fillMaxWidth()
        .border(
            width = 1.dp,
            color = MatuleColors.inputStroke,
            shape = RoundedCornerShape(MatuleSpacers.spacer12)
        ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MatuleSpacers.spacer16)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = text,
                color = Color.Black,
                style = MatuleTypography.titleMedium17
            )
        }
    }
}