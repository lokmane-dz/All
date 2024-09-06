package me.lokmvne.mylearning.presentation.authScreens

const val LOGIN_ROUTE = "login"
const val PROFILE_ROUTE = "profile"

sealed class AuthScreens(val route: String) {
    object SigInScreen : AuthScreens(LOGIN_ROUTE)
    object homeScreen : AuthScreens(PROFILE_ROUTE)
}