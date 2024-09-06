package me.lokmvne.learning.presentation.authScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.lokmvne.learning.R


@Composable
fun SignInScreen(
    navController: NavHostController,
    googleSignIn: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SignIn Screen")
        Spacer(modifier = Modifier.height(30.dp))
        MyButton(
            R.drawable.search, "Start With Google", onClick = {
                googleSignIn()
            },
            250
        )
    }

}

@Composable
fun MyButton(picture: Int, text: String, onClick: () -> Unit, width: Int = 200) {
    Button(
        modifier = Modifier
            .width(width.dp)
            .height(50.dp),
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Color.Black,
            contentColor = Color.White,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = picture),
                contentDescription = text
            )
            Text(text = text, fontSize = 18.sp)
        }
    }
}
