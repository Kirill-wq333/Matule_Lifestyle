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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matule20.ui.presentation.feature.product.viewmodel.ProductViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.bottomsheet.MatuleBottomSheet
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun ProductBottomSheet(
    vm: ProductViewModel,
    onDismissRequest: () -> Unit
) {
    val product by vm.productById.collectAsState()

    MatuleBottomSheet(
        nameProduct = product.title,
        onDismissRequest = onDismissRequest,
        content = {
            Column() {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.description),
                        color = Color(0xFF939396),
                        style = MatuleTypography.headlineMedium16
                    )
                    Text(
                        text = product.description,
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
                        text = product.approximateCost,
                        color = Color.Black,
                        style = MatuleTypography.headlineMedium16
                    )
                }
                Spacer(modifier = Modifier.height(19.dp))
                MatuleButton(
                    activeBtn = true,
                    textBtn = stringResource(R.string.btn_added_for, product.price),
                    onClick = {}
                )
            }
        }
    )

}