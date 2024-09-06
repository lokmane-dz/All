package me.lokmvne.losounds.presentation

const val WELCOME_SCREEN = "welcome_screen"
const val HOME_SCREEN = "home_screen"

sealed class Screens(val route: String) {
    object WelcomeScreen : Screens(WELCOME_SCREEN)
    object HomeScreen : Screens(HOME_SCREEN)
}