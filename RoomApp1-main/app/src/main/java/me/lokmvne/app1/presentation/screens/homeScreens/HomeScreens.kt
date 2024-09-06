package me.lokmvne.app1.presentation.screens.homeScreens

const val ADD_PICTURE_VAR1 = "var1"
const val ADD_PICTURE_VAR2 = "var2"
const val HOME_ROUTE = "homeRoute"

sealed class HomeScreens(val route: String) {
    object GetAllPictures : HomeScreens("get_all_pictures")

//    object AddPicture : Screen("add_picture/{$ADD_PICTURE_VAR1}/{$ADD_PICTURE_VAR2}") {
//        fun passid(id: Int): String {
//            return "add_picture/$id"
//        }
//
//        fun passVariables(var1: Int, var2: String): String {
//            return "add_picture/$var1/$var2"
//        }
//    }

    object AddPicture :
        HomeScreens("add_picture?var1={$ADD_PICTURE_VAR1}&var2={$ADD_PICTURE_VAR2}") {
        fun passVariables(var1: Int = 0, var2: String = "NoData"): String {
            return "add_picture?var1=$var1&var2=$var2"
        }
    }
}