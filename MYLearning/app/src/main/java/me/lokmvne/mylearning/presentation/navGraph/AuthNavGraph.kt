package me.lokmvne.mylearning.presentation.navGraph

import android.app.Activity.RESULT_OK
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import me.lokmvne.mylearning.GoogleAuthUiClient
import me.lokmvne.mylearning.SignInViewmodel
import me.lokmvne.mylearning.presentation.authScreens.AuthScreens
import me.lokmvne.mylearning.presentation.authScreens.HomeScreen
import me.lokmvne.mylearning.presentation.authScreens.SignInScreen


@Composable
fun AuthNavGraph(
    navHostController: NavHostController,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    applicationContext: Context
) {
    val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    NavHost(navController = navHostController, startDestination = AuthScreens.SigInScreen.route) {
        composable(AuthScreens.SigInScreen.route) {

            val viewModel = viewModel<SignInViewmodel>()
            val state by viewModel.state.collectAsState()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUiClient.getSignedInUser() != null) {
                    navHostController.navigate(AuthScreens.homeScreen.route)
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        lifecycleCoroutineScope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            viewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        "Sign in successful",
                        Toast.LENGTH_LONG
                    ).show()

                    navHostController.navigate(AuthScreens.homeScreen.route)
                    viewModel.resetState()
                }
            }
            SignInScreen(
                navController = navHostController,
                googleSignIn = {
                    lifecycleCoroutineScope.launch {
                        val signInIntentSender = googleAuthUiClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(signInIntentSender ?: return@launch).build()
                        )
                    }
                }
            )
        }

        composable(AuthScreens.homeScreen.route) {
            HomeScreen(
                userData = googleAuthUiClient.getSignedInUser(),
                onSignOut = {
                    lifecycleCoroutineScope.launch {
                        googleAuthUiClient.signOut()
                        navHostController.navigate(AuthScreens.SigInScreen.route) {
                            popUpTo(AuthScreens.SigInScreen.route) {
                                inclusive = true
                            }
                        }
                    }
                }
            )
        }
    }
}