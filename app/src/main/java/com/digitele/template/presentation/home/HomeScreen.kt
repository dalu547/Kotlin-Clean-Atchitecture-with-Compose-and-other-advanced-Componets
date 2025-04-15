package com.digitele.template.presentation.home


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digitele.template.navgraph.AppRoute
import com.digitele.template.presentation.home.bottomscreens.DashboardScreen
import com.digitele.template.presentation.home.bottomscreens.ProfileScreen
import com.digitele.template.presentation.home.bottomscreens.SettingsScreen

@Composable
fun HomeScreen(mainAppNavController: NavHostController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavController = bottomNavController) }
    ) { paddingValues ->
        NavHost(
            navController = bottomNavController,
            startDestination = AppRoute.Dashboard.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(AppRoute.Dashboard.route) { DashboardScreen() }
            composable(AppRoute.Profile.route) { ProfileScreen() }
            composable(AppRoute.Settings.route) { SettingsScreen(mainAppNavController) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Create a sample NavHostController for preview
    val navController = rememberNavController()

    // Pass the navController to HomeScreen
    HomeScreen(navController)
}


