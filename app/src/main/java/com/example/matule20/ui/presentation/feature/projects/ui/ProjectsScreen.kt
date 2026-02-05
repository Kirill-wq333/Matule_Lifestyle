package com.example.matule20.ui.presentation.feature.projects.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.header.MatuleHeader

@Preview
@Composable
private fun ProjectsScreenPrev() {
    ProjectsScreen()
}

@Composable
fun ProjectsScreen() {
    Content()
}

@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                horizontal = 20.dp,
                vertical = 28.dp
            )
    ) {
        MatuleHeader(
            headerText = stringResource(R.string.projects),
            onBack = {},
            endIcon = R.drawable.ic_plus
        )
        Spacer(modifier = Modifier.height(18.dp))
        ProjectsContent()
    }
}

@Composable
fun ProjectsContent() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(7){
            Card(
                nameProduct = "Мой первый проект"
            )
        }
    }
}

