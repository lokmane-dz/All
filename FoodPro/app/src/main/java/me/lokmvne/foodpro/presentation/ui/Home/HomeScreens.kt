package me.lokmvne.foodpro.presentation.ui.Home

const val HOME_ROUTE = "home"
const val MAIN_ROUTE = "main"
const val PROFILE_ROUTE = "profile"
const val SETTINGS_ROUTE = "settings"
const val ABOUT_ROUTE = "about"


sealed class HomeScreens(val route: String) {
    object MainHomeScreen : HomeScreens(MAIN_ROUTE)
    object ProfileScreen : HomeScreens(PROFILE_ROUTE)
    object SettingsScreen : HomeScreens(PROFILE_ROUTE)
    object AboutScreen : HomeScreens(ABOUT_ROUTE)
}