package com.example.matule20.ui.presentation.feature.projects.ui

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.domain.ui.feature.project.model.Project
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.projects.viewmodel.ProjectViewModel
import com.example.matulelibrary.R
import com.example.matulelibrary.shared.card.Card
import com.example.matulelibrary.shared.header.MatuleHeader
import java.util.Date
import java.util.Locale

@Composable
fun ProjectsScreen(
    vm: ProjectViewModel,
    navController: NavHostController
) {
    val projects by vm.project.collectAsState()

    Content(
        projects = projects,
        navController = navController
    )
}

@Composable
private fun Content(
    projects: List<Project>,
    navController: NavHostController
) {
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
            visibleEndIcon = true,
            endIcon = R.drawable.ic_plus,
            addedNewProject = { navController.navigate(AppRoutes.CREATE_PROJECT) }
        )
        Spacer(modifier = Modifier.height(18.dp))
        ProjectsContent(
            projects = projects
        )
    }
}

@Composable
fun ProjectsContent(
    projects: List<Project>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(projects){ project ->
            Card(
                nameProduct = project.title,
                date = getSimpleTimeAgo(project.created)
            )
        }
    }
}
fun getSimpleTimeAgo(createdDate: String): String {
    return try {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val date = format.parse(createdDate)

        val now = Date()
        val diff = now.time - date.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24

        when {
            seconds < 60 -> "только что"
            minutes < 60 -> "$minutes мин назад"
            hours < 24 -> "$hours ч назад"
            days == 1L -> "вчера"
            days < 7 -> "$days дн назад"
            else -> {
                val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                dateFormat.format(date)
            }
        }
    } catch (e: Exception) {
        createdDate
    }
}