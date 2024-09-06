package me.lokmvne.mylearning

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import me.lokmvne.firebaseauth.FirebaseAuthActivity
import me.lokmvne.mylearning.presentation.navGraph.AuthNavGraph
import me.lokmvne.mylearning.ui.theme.MYLearningTheme

class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(applicationContext, FirebaseAuthActivity::class.java)
        enableEdgeToEdge()
        setContent {
            MYLearningTheme {
                navHostController = rememberNavController()
                AuthNavGraph(
                    navHostController = navHostController,
                    lifecycleCoroutineScope = lifecycleScope,
                    applicationContext = applicationContext
                )
            }
        }
    }
}
