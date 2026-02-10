package com.example.matule20.ui.presentation.feature

import androidx.compose.runtime.Composable
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
import com.example.matule20.ui.presentation.feature.createPassword.ui.CreatePasswordScreen
import com.example.matule20.ui.presentation.feature.createPassword.ui.CreateSecureCodeScreen
import com.example.matule20.ui.presentation.feature.main.ui.MainScreen
import com.example.matule20.ui.presentation.feature.main.viewmodel.MainViewModel
import com.example.matule20.ui.presentation.feature.profile.ui.ProfileScreen
import com.example.matule20.ui.presentation.feature.projects.ui.CreateProjectScreen
import com.example.matule20.ui.presentation.feature.projects.ui.ProjectsScreen
import com.example.matule20.ui.presentation.feature.register.ui.RegisterScreen
import com.example.matule20.ui.presentation.feature.register.viewmodel.RegisterViewModel
import com.example.matule20.ui.presentation.feature.splash.ui.SplashScreen

@Composable
fun NavigationBuilder(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppRoutes.SPLASH
    ){
        composable(AppRoutes.SPLASH){
            SplashScreen(
                navController = navController
            )
        }
        composable(AppRoutes.AUTH){
            val vmAuth = hiltViewModel<AuthViewModel>()
            AuthScreen(
                vm = vmAuth,
                navController = navController
            )
        }
        composable(AppRoutes.CART){
            CartScreen(
                navController = navController
            )
        }
        composable(AppRoutes.CATALOG){
            CatalogScreen(
                navController = navController
            )
        }
        composable(AppRoutes.MAIN){
            val vmMain = hiltViewModel<MainViewModel>()
            MainScreen(vmMain)
        }
        composable(AppRoutes.CREATE_PROJECT){
            CreateProjectScreen(
                navController = navController
            )
        }
        composable(AppRoutes.CREATE_NEW_PASSWORD){
            val vmCreatePassword = hiltViewModel<RegisterViewModel>()
            CreatePasswordScreen(
                vm = vmCreatePassword,
                navController = navController
            )
        }
        composable(AppRoutes.CREATE_SECURE_CODE_PASSWORD){
            CreateSecureCodeScreen(
                navController = navController
            )
        }
        composable(AppRoutes.PROFILE){
            ProfileScreen(
                navController = navController
            )
        }
        composable(AppRoutes.PROJECTS){
            ProjectsScreen(
                navController = navController
            )
        }
        composable(AppRoutes.REGISTER){
            RegisterScreen(
                navController = navController
            )
        }
    }
}