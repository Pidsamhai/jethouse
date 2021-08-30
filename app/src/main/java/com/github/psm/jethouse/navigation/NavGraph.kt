package com.github.psm.jethouse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.psm.jethouse.ui.page.ExplorePage
import com.github.psm.jethouse.ui.page.HomePage

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.HOME.route
    ) {
        composable(NavRoute.HOME.route) {
            HomePage(
                navigateToExplorePage = { navController.navigate(NavRoute.EXPLORE.route) }
            )
        }

        composable(NavRoute.EXPLORE.route) {
            ExplorePage(
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}