package com.digitele.template.navgraph

import PostScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digitele.template.presentation.home.HomeScreen
import com.digitele.template.presentation.login.LoginScreen
import com.digitele.template.presentation.other.TermsScreen
import com.digitele.template.presentation.splash.SplashScreen

@Composable
fun AppNavigation() {
    val mainAppNavController = rememberNavController()

    NavHost(navController = mainAppNavController, startDestination = AppRoute.Splash.route) {
        composable(AppRoute.Splash.route) {
            SplashScreen(mainAppNavController)
        }
        composable(AppRoute.Login.route) {
            LoginScreen(mainAppNavController = mainAppNavController)
        }
        composable(AppRoute.Home.route) {
            HomeScreen(mainAppNavController = mainAppNavController)
        }
        composable(AppRoute.Terms.route) {
            TermsScreen()
        }
        composable(AppRoute.Post.route) {
            PostScreen()
        }
    }
}
