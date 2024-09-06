package me.lokmvne.common_ui.components.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun AnimatedLogo(
    painter: Painter,
    contentDescription: String
) {
    var state by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        val startDelay = Random.nextLong(300, 900)
        delay(startDelay)
        state = true
    }

    val animAlpha by animateFloatAsState(
        targetValue = if (state) 1f else 0f,
        animationSpec = tween(
            durationMillis = 900,
            easing = FastOutSlowInEasing
        )
    )

    val animRotation by animateFloatAsState(
        targetValue = if (state) 360f else 0f,
        animationSpec = tween(
            durationMillis = 900,
            easing = FastOutSlowInEasing
        )
    )

    val animScale by animateFloatAsState(
        targetValue = if (state) 1f else 0f,
        animationSpec = tween(
            durationMillis = 900,
            easing = FastOutSlowInEasing
        )
    )

    Image(
        modifier = Modifier
            .size(128.dp)
            .graphicsLayer {
                alpha = animAlpha
                rotationX = animRotation
                rotationY = animRotation
                rotationZ = animRotation
                scaleX = animScale
                scaleY = animScale
            },
        painter = painter,
        contentDescription = contentDescription
    )
}