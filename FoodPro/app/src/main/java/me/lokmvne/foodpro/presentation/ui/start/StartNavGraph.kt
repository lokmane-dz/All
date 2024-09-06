package me.lokmvne.foodpro.presentation.ui.start

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.lokmvne.foodpro.presentation.ui.start.auth.LoginScreen
import me.lokmvne.foodpro.presentation.ui.start.auth.SignUpScreen
import me.lokmvne.foodpro.presentation.ui.start.onBoarding.OnBoardingScreen
import me.lokmvne.foodpro.presentation.ui.start.splash.SplashScreen

fun NavGraphBuilder.StartNavGraph(
    navHostController: NavHostController,
    lifecycle: LifecycleCoroutineScope
) {
    navigation(
        startDestination = StartScreens.SplashScreen.route,
        route = START_ROUTE
    ) {
        composable(StartScreens.SplashScreen.route) {
            SplashScreen(navHostController = navHostController, lifecycle)
        }
        composable(StartScreens.OnboardingScreen.route) {
            OnBoardingScreen(navHostController = navHostController,lifecycle)
        }
        composable(StartScreens.LoginScreen.route) {
            LoginScreen(navHostController)
        }
        composable(StartScreens.SignUpScreen.route) {
            SignUpScreen(navHostController)
        }
    }
}