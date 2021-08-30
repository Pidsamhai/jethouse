package com.github.psm.jethouse.navigation

sealed class NavRoute(val route: String) {
    object HOME: NavRoute(route = "home")
    object EXPLORE: NavRoute(route = "explore")
}
