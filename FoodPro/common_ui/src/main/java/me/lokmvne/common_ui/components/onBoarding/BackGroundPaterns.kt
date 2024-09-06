package me.lokmvne.common_ui.components.onBoarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import me.lokmvne.common_ui.ui.theme.TailwindCSSColor


@Composable
fun BackgroundPattern() {

    val path = Path().apply {
        moveTo(50f, 0f)
        lineTo(61f, 35f)
        lineTo(100f, 35f)
        lineTo(68f, 57f)
        lineTo(79f, 91f)
        lineTo(50f, 70f)
        lineTo(21f, 91f)
        lineTo(32f, 57f)
        lineTo(0f, 35f)
        lineTo(39f, 35f)
        close()
    }
    val paterncolor = TailwindCSSColor.Purple700
    Box() {
        Canvas(modifier = Modifier.offset(x = 0.dp, y = 0.dp)) {
            drawPath(path, color = paterncolor)
        }
    }
}