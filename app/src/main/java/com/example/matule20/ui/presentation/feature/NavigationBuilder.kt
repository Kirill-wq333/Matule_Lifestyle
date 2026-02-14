package com.example.matule20.ui.presentation.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.matule20.ui.presentation.approutes.AppRoutes
import com.example.matule20.ui.presentation.feature.auth.ui.AuthScreen
import com.example.matule20.ui.presentation.feature.auth.viewmodel.AuthViewModel
import com.example.matule20.ui.presentation.feature.cart.ui.CartScreen
import com.example.matule20.ui.presentation.feature.catalog.ui.CatalogScreen
import com.example.matule20.ui.presentation.feature.catalog.viewmodel.CatalogViewModel
import com.example.matule20.ui.presentation.feature.createPassword.ui.CreatePasswordScreen
import com.example.matule20.ui.presentation.feature.createPassword.ui.CreateSecureCodeScreen
import com.example.matule20.ui.presentation.feature.main.ui.MainScreen
import com.example.matule20.ui.presentation.feature.main.viewmodel.MainViewModel
import com.example.matule20.ui.presentation.feature.product.ui.ProductBottomSheet
import com.example.matule20.ui.presentation.feature.product.viewmodel.ProductViewModel
import com.example.matule20.ui.presentation.feature.profile.ui.ProfileScreen
import com.example.matule20.ui.presentation.feature.profile.viewmodel.ProfileViewModel
import com.example.matule20.ui.presentation.feature.projects.ui.CreateProjectScreen
import com.example.matule20.ui.presentation.feature.projects.ui.ProjectsScreen
import com.example.matule20.ui.presentation.feature.projects.viewmodel.ProjectViewModel
import com.example.matule20.ui.presentation.feature.register.ui.RegisterScreen
import com.example.matule20.ui.presentation.feature.register.viewmodel.RegisterViewModel
import com.example.matule20.ui.presentation.feature.splash.ui.SplashScreen

@Composable
fun NavigationBuilder(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val vmProduct = hiltViewModel<ProductViewModel>()
    var showProduct by remember { mutableStateOf(false) }
    var selectedProductId by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = AppRoutes.SPLASH
        ) {
            composable(AppRoutes.SPLASH) {
                SplashScreen(
                    navController = navController
                )
            }
            composable(AppRoutes.AUTH) {
                val vmAuth = hiltViewModel<AuthViewModel>()
                AuthScreen(
                    vm = vmAuth,
                    navController = navController
                )
            }
            composable(AppRoutes.CART) {
                CartScreen(
                    navController = navController
                )
            }
            composable(AppRoutes.CATALOG) {
                val vmCatalog = hiltViewModel<CatalogViewModel>()
                CatalogScreen(
                    vm = vmCatalog,
                    navController = navController,
                    openProduct = { id ->
                        showProduct = true
                        selectedProductId = id
                        vmProduct.productById(id)
                    }
                )
            }
            composable(AppRoutes.MAIN) {
                val vmMain = hiltViewModel<MainViewModel>()
                MainScreen(
                    vm = vmMain,
                    openProduct = { id ->
                        showProduct = true
                        selectedProductId = id
                        vmProduct.productById(id)
                    }
                )
            }
            composable(AppRoutes.CREATE_PROJECT) {
                val vmCreateProject = hiltViewModel<ProjectViewModel>()
                CreateProjectScreen(
                    vm = vmCreateProject,
                    navController = navController
                )
            }
            composable(AppRoutes.CREATE_NEW_PASSWORD) {
                val vmCreatePassword = hiltViewModel<RegisterViewModel>()
                CreatePasswordScreen(
                    vm = vmCreatePassword,
                    navController = navController
                )
            }
            composable(AppRoutes.CREATE_SECURE_CODE_PASSWORD) {
                CreateSecureCodeScreen(
                    navController = navController
                )
            }
            composable(AppRoutes.PROFILE) {
                val vmProfile = hiltViewModel<ProfileViewModel>()
                ProfileScreen(
                    vm = vmProfile,
                    navController = navController
                )
            }
            composable(AppRoutes.PROJECTS) {
                val vmProject = hiltViewModel<ProjectViewModel>()
                ProjectsScreen(
                    vm = vmProject,
                    navController = navController
                )
            }
            composable(AppRoutes.REGISTER) {
                RegisterScreen(
                    navController = navController
                )
            }
        }
        if (showProduct) {
            ProductBottomSheet(
                vm = vmProduct,
                onDismissRequest = { showProduct = false }
            )
        }
    }
}