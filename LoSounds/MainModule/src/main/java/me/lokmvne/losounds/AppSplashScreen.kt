package me.lokmvne.losounds

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.lokmvne.losounds.presentation.Screens
import me.lokmvne.losounds.presentation.SplashViewmodel
import me.lokmvne.losounds.ui.theme.LoSoundsTheme

@AndroidEntryPoint
class AppSplashScreen : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val intent = Intent(this, MainActivity::class.java)

        setContent {
            LoSoundsTheme {
                val splashViewModel: SplashViewmodel = hiltViewModel()
                val startScreen = splashViewModel.startDestination.collectAsState()
                LoSoundsTheme {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedVisibility(
                            visible = true,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.play),
                                contentDescription = "logo",
                                modifier = Modifier.size(150.dp)
                            )
                        }
                    }
                    lifecycleScope.launch {
                        delay(500)
                        startScreen.value.let {
                            when (it) {
                                Screens.WelcomeScreen.route -> {
                                    intent.putExtra("startdest", Screens.WelcomeScreen.route)
                                    startActivity(intent)
                                }

                                Screens.HomeScreen.route -> {
                                    intent.putExtra("startdest", Screens.HomeScreen.route)
                                    startActivity(intent)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}