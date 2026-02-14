package com.example.matule20.ui.presentation.feature.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.domain.ui.feature.product.model.Products
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.catalog.viewmodel.CatalogViewModel
import com.example.matule20.ui.presentation.feature.main.ui.CatalogDescription
import com.example.matule20.ui.presentation.feature.main.ui.MainProduct
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.CartButton
import com.example.matulelibrary.shared.input.SearchTextField

@Composable
fun CatalogScreen(
    vm: CatalogViewModel,
    openProduct: (String) -> Unit,
    navController: NavHostController
) {
   val products by vm.products.collectAsState()
    LaunchedEffect(Unit) {
        vm.content()
    }
    Content(
        products = products,
        navController = navController,
        openProduct = openProduct
    )
}

@Composable
fun Content(
    products: List<Products>,
    openProduct: (String) -> Unit,
    navController: NavHostController
) {
    var search by remember { mutableStateOf("") }
    val catalog = remember(products) {
        listOf("Все") + products.map { it.typeCloses }.toSet().toList().sorted()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 28.dp, bottom = 32.dp)
    ) {
        CatalogContent(
            catalog = catalog,
            products = products,
            search = search,
            onSearchChange = { search = it },
            clearSearch = { search = "" },
            openProduct = openProduct,
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
    catalog: List<String>,
    products: List<Products>,
    search: String,
    openProduct: (String) -> Unit,
    openProfileScreen: () -> Unit,
    onSearchChange: (String) -> Unit,
    clearSearch: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState( pageCount = { catalog.size })
    val searchResults = remember(search, products) {
        if (search.isNotEmpty()){
            products.filter { products ->
                products.title.contains(search, ignoreCase = true)
            }
        } else {
            emptyList()
        }
    }
    LaunchedEffect(selectedCategory) {
        if (selectedCategory != pagerState.currentPage) {
            pagerState.animateScrollToPage(selectedCategory)
        }
    }

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
        CatalogDescription(
            catalog = catalog,
            pagerState = pagerState,
            onCatalogSelected = {
                selectedCategory = it
            }
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val productsPager = if (page == 0){
                searchResults
            } else {
                val subCategory = catalog.getOrNull(page) ?: ""
                searchResults.filter { it.typeCloses == subCategory }
            }

            MainProduct(
                nameProduct = productsPager,
                openProduct = openProduct
            )
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