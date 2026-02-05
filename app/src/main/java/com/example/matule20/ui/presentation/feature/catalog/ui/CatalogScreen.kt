package com.example.matule20.ui.presentation.feature.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.CartButton
import com.example.matulelibrary.shared.button.ChipsButton
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.input.SearchTextField

@Preview
@Composable
private fun CatalogScreenPrev() {
    CatalogScreen()
}

@Composable
fun CatalogScreen() {
    Content()
}

@Composable
private fun Content() {
    var search by remember { mutableStateOf("") }
    var visibleCartButton by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 28.dp
                ),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            SearchAndProfile(
                search = search,
                onSearchChange = { search = it },
                clearSearch = { search = "" }
            )
            CatalogContent(
                genre = listOf(
                    "Все",
                    "Мальчикам",
                    "Девочкам"
                )
            )
        }
        if (visibleCartButton) {
            CartButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 20.dp, vertical = 32.dp),
                price = 4214,
                onClick = {}
            )
        }
    }
}

@Composable
fun CatalogContent(
    genre: List<String>,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(genre){
                ChipsButton(
                    textBtn = it,
                    onClick = {}
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(10) {
                Card(
                    visibleCard = true,
                    nameProduct = "gdgddhdhd"
                )
            }
        }
    }
}

@Composable
fun SearchAndProfile(
    search: String,
    onSearchChange: (String) -> Unit,
    clearSearch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(38.dp)
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            search = search,
            onSearchChange = onSearchChange,
            clearSearch = clearSearch,
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_user),
            contentDescription = null
        )
    }
}