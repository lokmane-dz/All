package me.lokmvne.app1.presentation.screens.authScreens

const val AUTH_ROUTE = "authRoute"

sealed class AuthScreens(val route: String) {
    object LoginScreen : AuthScreens("loginScreen")
    object SignUpScreen : AuthScreens("SignUpScreen")
}