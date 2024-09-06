package me.lokmvne.app1.presentation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import me.lokmvne.app1.presentation.screens.homeScreens.ADD_PICTURE_VAR1
import me.lokmvne.app1.presentation.screens.homeScreens.ADD_PICTURE_VAR2
import me.lokmvne.app1.presentation.screens.homeScreens.AddPictureScreen
import me.lokmvne.app1.presentation.screens.homeScreens.GetAllPictures
import me.lokmvne.app1.presentation.screens.homeScreens.HOME_ROUTE
import me.lokmvne.app1.presentation.screens.homeScreens.HomeScreens

fun NavGraphBuilder.HomeGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = HomeScreens.GetAllPictures.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = HomeScreens.GetAllPictures.route,

            ) {
            GetAllPictures(navHostController)
        }

        composable(
            route = HomeScreens.AddPicture.route,
            arguments = listOf(
                navArgument(ADD_PICTURE_VAR1) {
                    type = NavType.IntType
                    defaultValue = 0
                },
                navArgument(ADD_PICTURE_VAR2) {
                    type = NavType.StringType
                    defaultValue = "No Data"
                    //nullable = true
                }
            )
        ) {
            val var1 = it.arguments!!.getInt(ADD_PICTURE_VAR1)
            val var2 = it.arguments!!.getString(ADD_PICTURE_VAR2)
            AddPictureScreen(navHostController, var1, var2)
        }
    }
}