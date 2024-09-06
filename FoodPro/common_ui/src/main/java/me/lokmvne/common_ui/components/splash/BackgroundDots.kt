package me.lokmvne.common_ui.components.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.delay
import kotlin.math.min
import kotlin.random.Random

@Composable
fun BackgroundDots() {
    val density = LocalDensity.current
    val dotColor = MaterialTheme.colorScheme.onBackground.copy(
        alpha = 0.1f
    )

    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        with(density) {
            val maxWidth = maxWidth
            val maxHeight = maxHeight

            for (i in 0..50) {
                var state by remember { mutableStateOf(false) }

                LaunchedEffect(Unit) {
                    delay(Random.nextLong(300, 5000))
                    state = true
                }

                val animScale by animateFloatAsState(
                    targetValue = if (state) 1f else .75f,
                    animationSpec = tween(
                        durationMillis = 12000,
                        easing = LinearEasing
                    )
                )

                val animCenterX by animateFloatAsState(
                    targetValue = if (state) .8f else 1f,
                    animationSpec = tween(
                        durationMillis = 9000,
                        easing = FastOutSlowInEasing
                    )
                )

                val animCenterY by animateFloatAsState(
                    targetValue = if (state) .8f else 1f,
                    animationSpec = tween(
                        durationMillis = 9000,
                        easing = FastOutSlowInEasing
                    )
                )

                val centerX = remember {
                    Random.nextInt(0, maxWidth.toPx().toInt()).toFloat()
                }
                val centerY = remember {
                    Random.nextInt(0, maxHeight.toPx().toInt()).toFloat()
                }
                val radius = remember {
                    Random.nextInt(16, min(maxWidth.toPx(), minHeight.toPx()).toInt() / 14)
                        .toFloat()
                }
                val alpha = remember { (Random.nextInt(10, 85) / 100f) }

                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = dotColor,
                        center = Offset(
                            x = if (i % 2 != 0) centerX * animCenterX else centerX,
                            y = if (i % 2 == 0) centerY * animCenterY else centerY
                        ),
                        radius = radius * animScale,
                        alpha = alpha
                    )
                }
            }
        }

    }
}