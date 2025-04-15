package com.digitele.template.presentation.home

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.digitele.template.navgraph.AppRoute

@Composable
fun BottomNavigationBar(bottomNavController: NavController) {
    val items = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Profile,
        BottomNavItem.Settings
    )

    val activeColor = Color(0xFF007E2F)  // Leafy green
    val inactiveColor = Color(0xFF505050)  // Grey for inactive icons

    Surface(
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 8.dp // Subtle shadow effect
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            val navBackStackEntry = bottomNavController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route

            items.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            bottomNavController.navigate(item.route) {
                                popUpTo(AppRoute.Home.route)
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon, // Use ImageVector for Material Icons
                            contentDescription = item.label,
                            tint = if (currentRoute == item.route) activeColor else inactiveColor
                        )
                    },
                    label = {
                        Text(
                            text = item.label,
                            color = if (currentRoute == item.route) activeColor else inactiveColor
                        )
                    }
                )
            }
        }
    }
}
