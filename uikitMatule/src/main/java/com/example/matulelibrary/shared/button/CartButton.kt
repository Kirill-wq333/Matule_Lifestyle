package com.example.matulelibrary.shared.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.color.MatuleColors
import com.example.matulelibrary.spacers.MatuleSpacers
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun CartButton(
    price: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .fillMaxWidth()
            .background(color = MatuleColors.accent, shape = RoundedCornerShape(10.dp))
            .padding(MatuleSpacers.spacer16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MatuleSpacers.spacer16)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_shopping_cart),
                contentDescription = null,
                tint = MatuleColors.white
            )
            Text(
                text = stringResource(R.string.in_cart),
                color = MatuleColors.white,
                style = MatuleTypography.titleSemiBold17
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "$price",
                color = MatuleColors.white,
                style = MatuleTypography.titleSemiBold17
            )
            Text(
                text = stringResource(R.string.rubles),
                color = MatuleColors.white,
                style = MatuleTypography.titleSemiBold17
            )
        }
    }
}

