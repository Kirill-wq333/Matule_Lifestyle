package com.example.matulelibrary.shared.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.counter.Counter
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun Card(
    nameProduct: String,
    visibleClose: Boolean = false,
    visibleCard: Boolean = false,
    visibleCart: Boolean = false,
) {
    var addedProduct by remember { mutableStateOf(false) }
    var quantity by remember { mutableStateOf(1) }

    val spacer = when{
        visibleCard -> 16.dp
        visibleCart -> 34.dp
        else -> 44.dp
    }

    Column(
        modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .border(width = 1.dp, color = Color(0xFFF4F4F4), shape = RoundedCornerShape(12.dp))
            .shadow(
                elevation = 0.dp,
                shape = RoundedCornerShape(12.dp),
                clip = true,
                ambientColor = Color(0xFFE4E8F5).copy(alpha = 0.6f),
                spotColor = Color(0xFFE4E8F5).copy(alpha = 0.6f)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(spacer)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = nameProduct,
                color = Color.Black,
                style = MatuleTypography.headlineMedium16
            )
            if (visibleClose) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
        when{
            visibleCard -> {
                CardItem(
                    money = 300,
                    genre = "dfgdfgdg",
                    onClick = { addedProduct = !addedProduct },
                    addedProduct = addedProduct,
                )
            }
            visibleCart -> {
                CartItem(
                    quantity = quantity,
                    money = 300,
                    onPlus = { quantity += 1 },
                    onMinus = { quantity -= 1 }
                )
            }
            else -> {
                ProjectItem(
                    date = "sdfhshsdh"
                )
            }
        }

    }
}

@Composable
private fun CardItem(
    money: Int,
    genre: String,
    onClick: () -> Unit,
    addedProduct: Boolean

) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = genre,
                color = Color(0xFF939396),
                style = MatuleTypography.captionSemiBold14
            )
            Text(
                text = stringResource(R.string.money, money),
                color = Color.Black,
                style = MatuleTypography.titleSemiBold17
            )
        }
        MatuleButton(
            textBtn = stringResource(if (addedProduct) R.string.btn_remove else R.string.btn_add),
            onClick = onClick,
            isBigBtn = false,
            activeBtn = !addedProduct,
            notBackground = addedProduct
        )
    }
}

@Composable
fun CartItem(
    quantity: Int,
    money: Int,
    onPlus: () -> Unit,
    onMinus: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.money, money),
            color = Color.Black,
            style = MatuleTypography.titleSemiBold17
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(42.dp)
        ) {
            Text(
                text = "$quantity",
                color = Color.Black,
                style = MatuleTypography.textRegular15
            )
            Counter(
                onPlus = onPlus,
                onMinus = onMinus,
                quantity = quantity
            )
        }
    }
}

@Composable
private fun ProjectItem(
    date: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = date,
            color = Color(0xFF939396),
            style = MatuleTypography.captionSemiBold14
        )
        MatuleButton(
            textBtn = stringResource(R.string.btn_open),
            onClick = {},
            activeBtn = true,
            isBigBtn = false
        )
    }
}