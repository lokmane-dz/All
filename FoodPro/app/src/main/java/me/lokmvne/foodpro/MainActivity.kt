package me.lokmvne.foodpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.lokmvne.common_ui.ui.theme.FoodProTheme
import me.lokmvne.foodpro.presentation.ui.navGraphs.NavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navHostController = rememberNavController()
            FoodProTheme {
                NavGraph(
                    navHostController = navHostController,
                    lifecycle = lifecycleScope,
                )
            }
        }
    }
}