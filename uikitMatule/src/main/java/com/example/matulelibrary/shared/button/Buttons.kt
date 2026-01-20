package com.example.matulelibrary.shared.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun BigButton(
    textBtn: String,
    activeBtn: Boolean = false,
    unactiveBtn: Boolean = false,
    notBackground: Boolean = false,
    onClick: () -> Unit,
    enable: Boolean
){
    val background = when{
        activeBtn -> MatuleColors.accent
        unactiveBtn -> MatuleColors.accentInactive
        notBackground -> Color.Transparent
        else -> MatuleColors.inputBg
    }

    val color = when{
        activeBtn -> MatuleColors.white
        unactiveBtn -> MatuleColors.white
        notBackground -> MatuleColors.accent
        else -> MatuleColors.black
    }

    Content(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (notBackground) MatuleColors.accent else Color.Transparent,
                shape = RoundedCornerShape(10.dp))
            .background(
                color = background,
                shape = RoundedCornerShape(10.dp)
            ),
        textBtn = textBtn,
        color = color,
        style = MatuleTypography.titleMedium17,
        verticalPadding = 16.dp,
        onClick = onClick,
        enable = enable
    )
}

@Composable
fun SmallButton(
    textBtn: String,
    activeBtn: Boolean = false,
    unactiveBtn: Boolean = false,
    notBackground: Boolean = false,
    onClick: () -> Unit,
    enable: Boolean

) {
    val background = when {
        activeBtn -> MatuleColors.accent
        unactiveBtn -> MatuleColors.accentInactive
        notBackground -> Color.Transparent
        else -> MatuleColors.inputBg
    }
    val color = when {
        activeBtn -> MatuleColors.white
        unactiveBtn -> MatuleColors.white
        notBackground -> MatuleColors.accent
        else -> MatuleColors.black
    }

    Content(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (notBackground) MatuleColors.accent else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = background,
                shape = RoundedCornerShape(10.dp)
            ),
        textBtn = textBtn,
        color = color,
        style = MatuleTypography.captionSemiBold14,
        verticalPadding = 10.dp,
        horizontalPadding = 15.dp,
        onClick = onClick,
        enable = enable
    )
}

@Composable
fun ChipsButton(
    textBtn: String,
    isSelectedColor: Boolean = false,
    onClick: () -> Unit
){
    Content(
        modifier = Modifier
            .background(
                color = if (isSelectedColor) MatuleColors.accent else MatuleColors.inputBg,
                shape = RoundedCornerShape(10.dp)
            ),
        textBtn = textBtn,
        color = if (isSelectedColor) MatuleColors.white else MatuleColors.description,
        style = MatuleTypography.textMedium15,
        verticalPadding = 14.dp,
        horizontalPadding = 20.dp,
        onClick = onClick
    )
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    textBtn: String,
    onClick: () -> Unit,
    enable: Boolean = true,
    color: Color,
    style: TextStyle,
    verticalPadding: Dp,
    horizontalPadding: Dp = 0.dp
){
    Box(
        modifier = modifier
            .clickable(enabled = enable, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = textBtn,
            color = color,
            style = style,
            modifier = Modifier
                .padding(vertical = verticalPadding, horizontal = horizontalPadding)
        )
    }
}