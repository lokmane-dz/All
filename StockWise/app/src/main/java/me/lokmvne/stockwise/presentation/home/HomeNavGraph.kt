package me.lokmvne.stockwise.presentation.home

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    context: Context,
    lifecycleCoroutineScope: LifecycleCoroutineScope
) {
    NavHost(navController = navHostController, startDestination = HomeScreens.SellingScreen.route) {
        composable(route = HomeScreens.SellingScreen.route) {
            SellingScreen(navHostController)
        }

        composable(route = HomeScreens.AddProductScreen.route) {
            AddItemsScreen(navHostController)
        }

        composable(route = HomeScreens.AddProductScreen.route) {
            AddItemsScreen(navHostController)
        }

    }
}