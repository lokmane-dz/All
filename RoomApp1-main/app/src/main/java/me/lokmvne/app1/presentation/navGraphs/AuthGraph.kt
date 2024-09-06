package me.lokmvne.app1.presentation.navGraphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.lokmvne.app1.presentation.screens.authScreens.AUTH_ROUTE
import me.lokmvne.app1.presentation.screens.authScreens.AuthScreens
import me.lokmvne.app1.presentation.screens.authScreens.Login
import me.lokmvne.app1.presentation.screens.authScreens.Signup

fun NavGraphBuilder.AuthGraph(
    navHostController: NavHostController
) {
    navigation(
        startDestination = AuthScreens.LoginScreen.route,
        route = AUTH_ROUTE
    ) {
        composable(
            AuthScreens.LoginScreen.route
        ) {
            Login(navController = navHostController)
        }

        composable(
            AuthScreens.SignUpScreen.route
        ) {
            Signup(navController = navHostController)
        }
    }
}