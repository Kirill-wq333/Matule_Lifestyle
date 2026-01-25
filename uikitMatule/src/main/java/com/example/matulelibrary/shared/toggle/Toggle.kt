package com.example.matulelibrary.shared.toggle

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.color.MatuleColors

@Composable
fun Toggle() {
    var isSelected by remember { mutableStateOf(false) }
    val backColor by animateColorAsState(
        targetValue = if (isSelected) MatuleColors.accent else MatuleColors.inputStroke,
        animationSpec = tween(500)
    )
    val paddingLeft by animateDpAsState(
        targetValue = if (isSelected) 22.dp else 2.dp,
        animationSpec = tween(500)
    )
    val paddingRight by animateDpAsState(
        targetValue = if (isSelected) 2.dp else 22.dp,
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier
            .clickable(
                onClick = { isSelected = !isSelected }
            )
            .background(
                color = backColor,
                shape = CircleShape
            )
    ) {
        Box(
            modifier = Modifier
                .padding(
                    start = paddingLeft,
                    end = paddingRight,
                    top = 2.dp,
                    bottom = 2.dp
                )
                .size(24.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        )
    }
}