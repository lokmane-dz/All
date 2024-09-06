package me.lokmvne.app1.presentation.navGraphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.lokmvne.app1.presentation.screens.authScreens.AUTH_ROUTE
import me.lokmvne.app1.presentation.screens.homeScreens.ADD_PICTURE_VAR1
import me.lokmvne.app1.presentation.screens.homeScreens.ADD_PICTURE_VAR2
import me.lokmvne.app1.presentation.screens.homeScreens.AddPictureScreen
import me.lokmvne.app1.presentation.screens.homeScreens.GetAllPictures
import me.lokmvne.app1.presentation.screens.homeScreens.HomeScreens

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AUTH_ROUTE
    ) {
        AuthGraph(navController)
        HomeGraph(navController)
    }
}