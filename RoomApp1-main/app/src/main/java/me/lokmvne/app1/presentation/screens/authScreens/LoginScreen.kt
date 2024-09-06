package me.lokmvne.app1.presentation.screens.authScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import me.lokmvne.app1.presentation.screens.homeScreens.HOME_ROUTE

@Composable
fun Login(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navController.popBackStack()
            navController.navigate(HOME_ROUTE)
        }) {
            Text(text = "Show Pictures")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navController.navigate(AuthScreens.SignUpScreen.route)
        }) {
            Text(text = "Go to SignUp")
        }
    }
}