package com.example.matulelibrary.shared.button.iconbtn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors

@Composable
fun BigIconButton(onClick: () -> Unit) {
    SmallIconButton(
        shape = RoundedCornerShape(10.dp),
        icon = R.drawable.ic_filter,
        padding = 14.dp,
        onClick = onClick,
    )
}

@Composable
fun SmallIconButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(6.dp),
    icon: Int,
    padding: Dp = 6.dp,
    size: Dp = 20.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .background(
                color = MatuleColors.inputBg,
                shape = shape
                )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = MatuleColors.description,
            modifier = Modifier
                .padding(padding)
                .size(size)
        )
    }
}