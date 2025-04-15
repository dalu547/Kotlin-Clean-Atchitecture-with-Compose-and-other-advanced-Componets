package com.digitele.template.navgraph

sealed class AppRoute(val route: String) {
    data object Splash : AppRoute("splash")
    data object Login : AppRoute("login")
    data object Home : AppRoute("home")
    data object Dashboard : AppRoute("dashboard")
    data object Profile : AppRoute("profile")
    data object Settings : AppRoute("settings")
    data object Terms : AppRoute("terms")
    data object Post : AppRoute("post")

}