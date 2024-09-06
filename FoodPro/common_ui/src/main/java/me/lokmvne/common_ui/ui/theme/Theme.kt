package me.lokmvne.common_ui.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = TailwindCSSColor.Gray900,
    onBackground = TailwindCSSColor.Gray50,
    primary = FlatColor.FlatBlue2,
    onPrimary = TailwindCSSColor.Gray100,
    secondary = TailwindCSSColor.Gray500,
    onSecondary = TailwindCSSColor.Gray50,
    tertiary = FlatColor.FlatGreyDark1,
    onTertiary = TailwindCSSColor.Gray50,
    error = TailwindCSSColor.Red700,
    onError = TailwindCSSColor.Gray50
)

private val LightColorScheme = lightColorScheme(
    background = TailwindCSSColor.Gray50,
    onBackground = TailwindCSSColor.Gray900,
    primary = FlatColor.FlatGreyDark1,
    onPrimary = TailwindCSSColor.Gray50,
    secondary = TailwindCSSColor.Gray800,
    onSecondary = TailwindCSSColor.Gray50,
    tertiary = FlatColor.FlatGreyDark1,
    onTertiary = TailwindCSSColor.Gray50,
    error = TailwindCSSColor.Red700,
    onError = TailwindCSSColor.Gray50
)

@Composable
fun FoodProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}