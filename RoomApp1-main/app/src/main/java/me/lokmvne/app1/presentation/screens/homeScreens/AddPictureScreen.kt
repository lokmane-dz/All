package me.lokmvne.app1.presentation.screens.homeScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.lokmvne.app1.data.MyPicture
import me.lokmvne.app1.presentation.viewmodels.AddPictureViewModel

@Composable
fun AddPictureScreen(navController: NavController, var1: Int, var2: String?) {
    val addPictureViewModel: AddPictureViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.primary)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField(
            value = addPictureViewModel.title.value,
            placeholder = "Title",
            onValueChange = { addPictureViewModel.title.value = it })
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField(
            value = addPictureViewModel.url.value,
            placeholder = "Url",
            onValueChange = { addPictureViewModel.url.value = it })
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField(
            value = addPictureViewModel.description.value,
            placeholder = "Description",
            onValueChange = { addPictureViewModel.description.value = it })
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField(
            value = addPictureViewModel.date.value,
            placeholder = "Date",
            onValueChange = { addPictureViewModel.date.value = it })
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField(
            value = addPictureViewModel.location.value,
            placeholder = "Location",
            onValueChange = { addPictureViewModel.location.value = it })
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            val mypicture = MyPicture(
                title = addPictureViewModel.title.value,
                url = addPictureViewModel.url.value,
                description = addPictureViewModel.description.value,
                date = addPictureViewModel.date.value,
                location = addPictureViewModel.location.value
            )
            addPictureViewModel.addPicture(mypicture)
            //reset the fields
            addPictureViewModel.title.value = ""
            addPictureViewModel.url.value = ""
            addPictureViewModel.description.value = ""
            addPictureViewModel.date.value = ""
            addPictureViewModel.location.value = ""
        }) {
            Text(text = "Add Picture")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = {
            navController.navigate(HomeScreens.GetAllPictures.route) {
                popUpTo(HomeScreens.GetAllPictures.route) {
                    inclusive = true
                }
            }
        }) {
            Text(text = "Show Pictures")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "var1 : $var1 and var2: $var2", color = colorScheme.onPrimary)
    }
}


@Composable
fun MyTextField(
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    value: String,
    placeholder: String = "",
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.width(300.dp),
        value = value,
        onValueChange = onValueChange,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorScheme.onPrimary,
            unfocusedTextColor = colorScheme.onPrimary,
            focusedBorderColor = colorScheme.onPrimary,
            unfocusedBorderColor = colorScheme.onPrimary,
            cursorColor = colorScheme.onPrimary,
            errorCursorColor = Color.Red,
        ),
        keyboardOptions = keyboardOptions,
        placeholder = { Text(text = placeholder) },
        singleLine = true
    )
}