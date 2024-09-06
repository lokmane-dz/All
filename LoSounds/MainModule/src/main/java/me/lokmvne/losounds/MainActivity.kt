package me.lokmvne.losounds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.lokmvne.losounds.presentation.Graphs.NavGraph
import me.lokmvne.losounds.presentation.Screens
import me.lokmvne.losounds.ui.theme.LoSoundsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val _extras = intent.extras
        val startdestination = _extras?.getString("startdest")
        setContent {
            navHostController = rememberNavController()
            LoSoundsTheme {
                NavGraph(
                    navHostController = navHostController,
                    startDestination = startdestination ?: Screens.HomeScreen.route
                )
            }
        }
    }
}