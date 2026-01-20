package com.example.matulelibrary.shared.button.iconbtn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors

@Composable
fun BigIconButton(onClick: () -> Unit) {
    SmallIconButton(
        shape = 10.dp,
        icon = R.drawable.ic_filter,
        padding = 14.dp,
        onClick = onClick
    )
}

@Composable
fun SmallIconButton(
    shape: Dp = 8.dp,
    icon: Int,
    padding: Dp = 6.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(
                color = MatuleColors.inputBg,
                shape = RoundedCornerShape(shape)
                )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            modifier = Modifier
                .padding(padding)
        )
    }
}