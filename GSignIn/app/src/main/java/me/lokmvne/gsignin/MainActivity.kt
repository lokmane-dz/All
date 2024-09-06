package me.lokmvne.gsignin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.lokmvne.gsignin.ui.theme.GSignInTheme
import kotlin.coroutines.cancellation.CancellationException


class MainActivity : ComponentActivity() {
    val context = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val signInViewModel = viewModel<SignInViewModel>(context)
            var res = signInViewModel.res.collectAsState()
            GSignInTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = res.value.name ?: "no data")
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = {
                        signInViewModel.viewSignIn(context)
                    }) {
                        Text(text = "Connect")
                    }
                }
            }
        }
    }
}


//lifecycleScope.launch {
//    try {
//        val response = signIn(credentialManager, context)
//        response
//        delay(5000)
//        Log.d("TAGGGGGGGGGG", "Response: $response")
//        if (response != null) handleSignIn(response)
//        else Toast.makeText(context, "Sign in failed", Toast.LENGTH_SHORT)
//            .show()
//    } catch (e: CancellationException) {
//        e.printStackTrace()
//        Toast.makeText(context, e.message, Toast.LENGTH_SHORT)
//            .show()
//    }
//}