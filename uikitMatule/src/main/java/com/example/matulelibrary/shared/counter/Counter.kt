package com.example.matulelibrary.shared.counter

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors

/**
 *
 * Универсальный компонент прибавления и убавления
 *
 * @param onPlus Лямбда-функция, которая при нажатии добавляет товар
 * @param onMinus Лямбда-функция, которая при нажатии убавляет товар
 * @param quantity Количество товаров
 */
@Composable
fun Counter(
    onMinus: () -> Unit,
    onPlus: () -> Unit,
    quantity: Int,
) {
    Row(
        modifier = Modifier
            .background(
                color = MatuleColors.inputBg,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                6.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_minus),
            contentDescription = null,
            tint = if (quantity <= 1) Color.Unspecified else Color(0xFF939396),
            modifier = Modifier
                .clickable(enabled = quantity >= 2, onClick = onMinus)
        )
        VerticalDivider(
            modifier = Modifier
                .height(16.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus),
            contentDescription = null,
            tint = Color(0xFF939396),
            modifier = Modifier
                .clickable(onClick = onPlus)
        )
    }
}