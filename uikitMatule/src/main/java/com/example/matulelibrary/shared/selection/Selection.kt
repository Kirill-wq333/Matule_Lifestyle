package com.example.matulelibrary.shared.selection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.typography.MatuleTypography

/**
 * Раскрывающаяся секция с заголовком и анимированным контентом.
 *
 * @param image Ресурс иконки для заголовка секции
 * @param selectionName Текст заголовка секции
 * @param visibleColorActive Флаг активности заголовка (меняет цвет текста иконки)
 * @param content Раскрывающийся контент
 */
@Composable
fun Selection(
    image: Int,
    selectionName: String,
    visibleColorActive: Boolean,
    content: @Composable () -> Unit = {}
) {
    var visibleDropMenu by remember { mutableStateOf(false) }

    val color = if (visibleColorActive) Color.Black else Color(0xFF939396)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MatuleColors.inputBg,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable{
                visibleDropMenu = !visibleDropMenu
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MatuleColors.inputBg,
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp,
                    color = MatuleColors.inputStroke,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = selectionName,
                    color = color,
                    style = MatuleTypography.headlineRegular16
                )
            }
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_chevron_down),
                contentDescription = null,
                modifier = Modifier
                    .rotate(
                        if (visibleDropMenu) 180f else 0f
                    )
            )
        }
        AnimatedVisibility(
            visible = visibleDropMenu,
            enter = fadeIn(tween(700)) + slideInVertically(tween(700)),
            exit = fadeOut(tween(700)) + slideOutVertically(tween(700))
        ) {
            content()
        }
    }
}