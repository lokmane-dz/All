package me.lokmvne.foodpro.presentation.ui.start.onBoarding

import androidx.annotation.DrawableRes
import me.lokmvne.foodpro.R

sealed class OnBoardingPage(
    @DrawableRes
    val painter: Int,
    val title: String,
    val description: String
) {
    object Screen1 : OnBoardingPage(
        painter = R.drawable.pic1,
        title = "Welcome to FoodPro",
        description = "The best place to find your coffee"
    )

    object Screen2 : OnBoardingPage(
        painter = R.drawable.pic2,
        title = "Discover",
        description = "Find new coffee shops and explore their menus"
    )

    object Screen3 : OnBoardingPage(
        painter = R.drawable.pic3,
        title = "FAVORITE",
        description = "Select your favorite coffee and order it in one click"
    )
}