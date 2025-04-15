package com.digitele.template.presentation.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Dashboard : BottomNavItem("dashboard", Icons.Filled.Home, "Dashboard")
    object Profile : BottomNavItem("profile", Icons.Filled.Person, "Profile")
    object Settings : BottomNavItem("settings", Icons.Filled.Settings, "Settings")
}
