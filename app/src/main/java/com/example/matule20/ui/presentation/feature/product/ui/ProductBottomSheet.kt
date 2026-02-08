package com.example.matule20.ui.presentation.feature.product.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.bottomsheet.MatuleBottomSheet
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.typography.MatuleTypography

@Preview
@Composable
private fun ProductPrev() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ProductBottomSheet(
            description = "Мой выбор для этих шапок – кардные составы, которые раскрываются деликатным пушком. Кашемиры, мериносы, смесовки с ними отлично подойдут на шапку. Кардные составы берите в большое количество сложений, вязать будем резинку 1х1, плотненько. Пряжу 1400-1500м в 100г в 4 сложения, пряжу 700м в 2 сложения. Ориентир для конечной толщины – 300-350м в 100г. Артикулы, из которых мы вязали эту модель: Zermatt Zegna Baruffa, Cashfive, Baby Cashmere Loro Piana, Soft Donegal и другие. Примерный расход на шапку с подгибом 70-90г.",
            price = 214,
            nameProduct = "Рубашка воскресенье для машинного вязания",
            approximateCost = "80-90 г"
        )
    }
}


@Composable
fun ProductBottomSheet(
    description: String,
    price: Int,
    nameProduct: String,
    approximateCost: String
) {
    MatuleBottomSheet(
        nameProduct = nameProduct,
        content = {
            Column() {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.description),
                        color = Color(0xFF939396),
                        style = MatuleTypography.headlineMedium16
                    )
                    Text(
                        text = description,
                        color = Color.Black,
                        style = MatuleTypography.textRegular15
                    )
                }
                Spacer(modifier = Modifier.height(49.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.approximate_cost),
                        color = Color(0xFF939396),
                        style = MatuleTypography.captionRegular14
                    )
                    Text(
                        text = approximateCost,
                        color = Color.Black,
                        style = MatuleTypography.headlineMedium16
                    )
                }
                Spacer(modifier = Modifier.height(19.dp))
                MatuleButton(
                    activeBtn = true,
                    textBtn = stringResource(R.string.btn_added_for, price),
                    onClick = {}
                )
            }
        }
    )

}