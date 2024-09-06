package me.lokmvne.stockwise.presentation.home

import me.lokmvne.stockwise.R

const val ADD_PRODUCT_SCREEN = "add_product"
const val INFO_PRODUCT_SCREEN = "info_product"
const val SELLING_PRODUCT_SCREEN = "Selling_product"

sealed class HomeScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object AddProductScreen : HomeScreens(
        route = ADD_PRODUCT_SCREEN,
        title = "Add",
        icon = R.drawable.add_circle_24px,
    )

    object ItemDetailScreen : HomeScreens(
        route = INFO_PRODUCT_SCREEN,
        title = "Info",
        icon = R.drawable.info_24px,
    )

    object SellingScreen : HomeScreens(
        route = SELLING_PRODUCT_SCREEN,
        title = "Selling",
        icon = R.drawable.payments_24px,
    )
}