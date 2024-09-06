package me.lokmvne.foodpro.presentation.ui.start

const val START_ROUTE = "auth"
const val LOGIN_ROUTE = "login"
const val SIGN_UP_ROUTE = "signup"
const val ONBOARDING_ROUTE = "onboarding"
const val SPLASH_ROUTE = "splash"

sealed class StartScreens(val route: String) {
    object LoginScreen : StartScreens(route = LOGIN_ROUTE)
    object SignUpScreen : StartScreens(route = SIGN_UP_ROUTE)
    object OnboardingScreen : StartScreens(route = ONBOARDING_ROUTE)
    object SplashScreen : StartScreens(route = SPLASH_ROUTE)
}