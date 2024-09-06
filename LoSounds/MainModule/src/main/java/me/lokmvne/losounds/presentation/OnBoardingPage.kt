package me.lokmvne.losounds.presentation

import androidx.annotation.DrawableRes
import me.lokmvne.losounds.R

sealed class OnBoardingPage(
    @DrawableRes
    val painter: Int,
    val title: String,
    val description: String
) {
    object Screen1 : OnBoardingPage(
        painter = R.drawable.pic1,
        title = "Welcome to LoSounds",
        description = "The best place to find and listen to music"
    )

    object Screen2 : OnBoardingPage(
        painter = R.drawable.pic2,
        title = "Discover",
        description = "Find new music and artists"
    )

    object Screen3 : OnBoardingPage(
        painter = R.drawable.pic3,
        title = "Create",
        description = "Create your own playlists and share them with others"
    )
}