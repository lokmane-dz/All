package me.lokmvne.losounds.presentation.Graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.lokmvne.homemodule.presentation.HomeScreen
import me.lokmvne.losounds.presentation.Screens
import me.lokmvne.losounds.presentation.WelcomeScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    startDestination: String,
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = Screens.WelcomeScreen.route) {
            WelcomeScreen(navHostController)
        }

        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navHostController)
        }
    }
}