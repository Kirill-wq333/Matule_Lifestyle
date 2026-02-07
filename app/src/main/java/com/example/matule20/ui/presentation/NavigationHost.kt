package com.example.matule20.ui.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.NavigationBuilder
import com.example.matulelibrary.shared.bottombar.BottomBar
import com.example.matulelibrary.shared.snackbar.ui.SnackBar

@Composable
fun NavigationHost(
    navController: NavHostController
) {

    var visibleSnackBar by remember { mutableStateOf(false) }
    val screensWithBottomBar = listOf(
        AppRoutes.MAIN,
        AppRoutes.CATALOG,
        AppRoutes.PROJECTS,
        AppRoutes.PROFILE
    )

    val currentDestination = navController
        .currentBackStackEntryAsState()
        .value
        ?.destination
        ?.route

    val shouldShowBottomBar = currentDestination in screensWithBottomBar

    Scaffold(
        snackbarHost = {
            if (visibleSnackBar) {
                SnackBar(
                    message = ""
                )
            }
        },
        bottomBar = {
            if (shouldShowBottomBar) {
                BottomBar(
                    navController = navController,
                    routesMain = AppRoutes.MAIN,
                    routesCatalog = AppRoutes.CATALOG,
                    routesProjects = AppRoutes.PROJECTS,
                    routesProfile = AppRoutes.PROFILE,
                )
            }
        }
    ) { padding ->
        NavigationBuilder(
            modifier = Modifier.padding(padding),
            navController = navController
        )
    }
}