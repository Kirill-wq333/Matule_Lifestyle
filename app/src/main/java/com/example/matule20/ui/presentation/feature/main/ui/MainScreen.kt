package com.example.matule20.ui.presentation.feature.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.ui.feature.news.model.News
import com.example.domain.ui.feature.product.model.Products
import com.example.matule20.ui.presentation.feature.main.viewmodel.MainViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.button.ChipsButton
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.input.SearchTextField
import com.example.matulelibrary.typography.MatuleTypography

@Composable
fun MainScreen(
    vm: MainViewModel
) {
    val products by vm.products.collectAsState()
    val news by vm.news.collectAsState()

    Content(
        products = products,
        news = news
    )
}


@Composable
fun Content(
    products: List<Products>,
    news: List<News>
) {
    var search by remember { mutableStateOf("") }
    val catalog = remember(products) {
        listOf("Все") + products.map { it.type }.toSet().toList().sorted()
    }
    var selectedCategory by remember { mutableStateOf(-1) }
    val pagerState = rememberPagerState( pageCount = { catalog.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 24.dp)
    ) {
        SearchTextField(
            search = search,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            onSearchChange = { search = it },
            clearSearch = { search = "" },
        )
        Spacer(modifier = Modifier.height(32.dp))
        PromotionsAndNews(
            promotionsAndNews = news.map { it.newsImage }
        )
        Spacer(modifier = Modifier.height(32.dp))
        CatalogDescription(
            catalog = catalog,
            isSelected = selectedCategory,
            onCatalogSelected = {
                selectedCategory == it
            }
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val productsPager = if (page == 0){
                products
            } else {
                val subCategory = catalog.getOrNull(page) ?: ""
                products.filter { it.type == subCategory }
            }

            MainProduct(
                nameProduct = productsPager
            )
        }
    }
}

@Composable
fun PromotionsAndNews(
    promotionsAndNews: List<String>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.promotions_and_news),
            color = Color(0xFF939396),
            style = MatuleTypography.titleSemiBold17,
            modifier = Modifier
                .padding(start = 20.dp)
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(promotionsAndNews){ item ->
                PromotionsAndNewsItem(
                    newsAndPromotions = item
                )
            }
        }
    }
}

@Composable
fun PromotionsAndNewsItem(
    newsAndPromotions: String
) {
    Box(
        modifier = Modifier
            .size(270.dp, 152.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        AsyncImage(
            model = newsAndPromotions,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }
}

@Composable
fun CatalogDescription(
    catalog: List<String>,
    onCatalogSelected: (Int) -> Unit,
    isSelected: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.catalog_of_descriptions),
            color = Color(0xFF939396),
            style = MatuleTypography.titleSemiBold17,
            modifier = Modifier
                .padding(start = 21.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(catalog){ index, item ->
                val isSelected = isSelected == index
                ChipsButton(
                    textBtn = item,
                    isSelectedColor = isSelected,
                    onClick = {
                        onCatalogSelected(index)
                    }
                )
            }
        }
    }
}

@Composable
fun MainProduct(
    nameProduct: List<Products>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(nameProduct) { item ->
            Card(
                nameProduct = item.title,
                money = item.price,
                genre = item.typeCloses,
                visibleCard = true
            )
        }
    }
}