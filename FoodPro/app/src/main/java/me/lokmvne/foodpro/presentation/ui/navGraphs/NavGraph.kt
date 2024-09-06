package me.lokmvne.foodpro.presentation.ui.navGraphs

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import me.lokmvne.foodpro.presentation.ui.Home.HomeNavGraph
import me.lokmvne.foodpro.presentation.ui.start.START_ROUTE
import me.lokmvne.foodpro.presentation.ui.start.StartNavGraph

const val MAIN_GRAPH_ROUTE = "mainGraph"

@Composable
fun NavGraph(
    navHostController: NavHostController,
    lifecycle: LifecycleCoroutineScope,
) {
    NavHost(
        navController = navHostController,
        startDestination = START_ROUTE,
        route = MAIN_GRAPH_ROUTE,
    ) {
        StartNavGraph(navHostController, lifecycle)
        HomeNavGraph(navHostController)
    }
}