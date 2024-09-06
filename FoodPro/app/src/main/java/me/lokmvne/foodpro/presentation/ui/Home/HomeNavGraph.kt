package me.lokmvne.foodpro.presentation.ui.Home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.HomeNavGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = HomeScreens.MainHomeScreen.route,
        route = HOME_ROUTE
    ) {

    }
}