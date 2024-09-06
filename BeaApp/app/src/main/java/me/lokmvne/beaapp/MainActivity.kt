package me.lokmvne.beaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import me.lokmvne.beaapp.presentation.BeerScreen
import me.lokmvne.beaapp.ui.theme.BeaAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeaAppTheme {
                BeerScreen()
            }
        }
    }
}