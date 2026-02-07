package com.example.matule20.ui.presentation.feature.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.CartButton
import com.example.matulelibrary.shared.button.ChipsButton
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.input.SearchTextField

@Preview
@Composable
private fun CatalogScreenPrev() {
    CatalogScreen(navController = rememberNavController())
}
@Composable
fun CatalogScreen(navController: NavHostController) {
    Content(
        navController = navController
    )
}

@Composable
fun Content(
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val genres = listOf(
        "Все", "Мужчинам", "Женщинам"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 28.dp, bottom = 32.dp)
    ) {
        CatalogContent(
            genres = genres,
            search = search,
            onSearchChange = { search = it },
            clearSearch = { search = "" },
            openProfileScreen = { navController.navigate(AppRoutes.PROFILE) }
        )
        CartButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp),
            price = 5325,
            onClick = { navController.navigate(AppRoutes.CART) }
        )
    }
}

@Composable
fun CatalogContent(
    genres: List<String>,
    search: String,
    openProfileScreen: () -> Unit,
    onSearchChange: (String) -> Unit,
    clearSearch: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SearchAndProfile(
            search = search,
            onSearchChange = onSearchChange,
            clearSearch = clearSearch,
            openProfileScreen = openProfileScreen
        )
        Spacer(modifier = Modifier.height(32.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            items(genres){
                ChipsButton(
                    textBtn = it,
                    onClick = {}
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(4){
                Card(
                    nameProduct = "Рубашка Воскресенье для машинного ",
                    visibleCard = true
                )
            }
        }
    }
}

@Composable
fun SearchAndProfile(
    search: String,
    onSearchChange: (String) -> Unit,
    clearSearch: () -> Unit,
    openProfileScreen: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(28.dp)
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            search = search,
            onSearchChange = onSearchChange,
            clearSearch = clearSearch
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_user),
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = openProfileScreen)
        )
    }
}