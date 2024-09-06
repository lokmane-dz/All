package me.lokmvne.foodpro.presentation.ui.start.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import me.lokmvne.common_ui.components.splash.AnimatedLogo
import me.lokmvne.common_ui.components.splash.AnimatedText
import me.lokmvne.common_ui.components.splash.BackgroundDots
import me.lokmvne.foodpro.R
import me.lokmvne.foodpro.presentation.ui.start.StartScreens

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(
    navHostController: NavHostController,
    lifecycle: LifecycleCoroutineScope
) {
    val splashScreenViewModel = hiltViewModel<SplashScreenViewModel>()
    val onBoardingStatus = splashScreenViewModel.OnboardingStatus.collectAsState()
    val onboardingres = lifecycle.async {
        splashScreenViewModel.getOnboardingStatus()
        delay(3000)
    }

    onboardingres.invokeOnCompletion {
        var destination: String
        onBoardingStatus.value.let {
            if (it) {
                destination = StartScreens.LoginScreen.route
            } else {
                destination = StartScreens.OnboardingScreen.route
            }
            navHostController.navigate(destination) {
                popUpTo(destination) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        BackgroundDots()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedLogo(
                painter = painterResource(id = R.drawable.ic_shield_logo),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedText(text = "FoodPro")
        }
    }
}