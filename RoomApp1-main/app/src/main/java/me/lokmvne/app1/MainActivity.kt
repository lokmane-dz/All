package me.lokmvne.app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.lokmvne.app1.presentation.navGraphs.NavGraph
import me.lokmvne.app1.ui.theme.App1Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App1Theme {
                navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}