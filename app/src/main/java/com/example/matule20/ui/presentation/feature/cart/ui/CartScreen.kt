package com.example.matule20.ui.presentation.feature.cart.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.MatuleButton
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.header.MatuleHeader
import com.example.matulelibrary.typography.MatuleTypography

@Preview
@Composable
private fun CartScreenPrev() {
    CartScreen()
}
@Composable
fun CartScreen() {
    Content()
}

@Composable
private fun Content() {
    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(
            start = 20.dp,
            end = 20.dp,
            top = 16.dp,
            bottom = 32.dp
        )
    ) {

        CartContent(
            sum = 500
        )
        MatuleButton(
            activeBtn = true,
            modifier = Modifier
                .align(Alignment.BottomCenter),
            textBtn = stringResource(R.string.go_to_checkout),
            onClick = {}
        )
    }
}

@Composable
fun CartContent(
    sum: Int
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        MatuleHeader(
            visibleSmallIcon = true,
            headerText = stringResource(R.string.cart),
            isCart = true,
            onBack = {},
            endIcon = R.drawable.ic_delete
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            items(2){
                Card(
                    nameProduct = "dfdhd",
                    visibleCart = true
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.sum),
                color = Color.Black,
                style = MatuleTypography.titleSemibold20
            )
            Text(
                text = stringResource(R.string.money, sum),
                color = Color.Black,
                style = MatuleTypography.titleSemibold20
            )
        }
    }
}