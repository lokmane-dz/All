package me.lokmvne.app1.presentation.screens.homeScreens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import me.lokmvne.app1.data.MyPicture
import me.lokmvne.app1.presentation.screens.authScreens.AUTH_ROUTE
import me.lokmvne.app1.presentation.viewmodels.GetPicturesViewModel

@Composable
fun GetAllPictures(navController: NavController) {
    val getPicturesViewModel: GetPicturesViewModel = hiltViewModel()
    //val pictures = getPicturesViewModel.pictureList.collectAsState()
    val context = LocalContext.current
    getPicturesViewModel.getPicture(context)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.primary)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row {
                    Button(onClick = {
                        navController.popBackStack()
                        navController.navigate(AUTH_ROUTE)
                    }) {
                        Text(text = "LogOut")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = {
                        navController.navigate(HomeScreens.AddPicture.passVariables())
                    }) {
                        Text(text = "Add Picture")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(onClick = {
                        getPicturesViewModel.isloading.value = true
                        getPicturesViewModel.getPicture(context)
                    }) {
                        Text(text = "Refresh")
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(getPicturesViewModel.pictures.value) { pic ->
                MyCard(pic, context)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        if (getPicturesViewModel.isloading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
            )
            MyCircularProgressIndicator()
        }
    }
}

@Composable
fun MyCard(pic: MyPicture, context: Context) {
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(pic.url)) }

    Card(
        modifier = Modifier
            .size(300.dp)
            .clickable { context.startActivity(intent) }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = pic.url,
                contentDescription = pic.description,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                filterQuality = FilterQuality.High
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 0f,
                            endY = 1100f,
                        )
                    ), contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = pic.description,
                        color = Color.White,
                        modifier = Modifier.padding(10.dp)
                    )
                    Text(text = pic.title, color = Color.White, modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}

@Composable
fun MyCircularProgressIndicator() {
    CircularProgressIndicator(
        modifier = Modifier
            .size(150.dp),
        color = Color.White,
        trackColor = Color.Gray,
        strokeWidth = 5.dp
    )
}