package com.example.pvh_cenima.ui.utility

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput


enum class ButtonState { Pressed, Idle }

fun Modifier.bounceClick(value: Float) = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(
        targetValue = if (buttonState == ButtonState.Pressed) value else 1f,
        label = "bounce_scale"
    )

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .pointerInput(Unit) { // Use Unit as key to avoid restarting the block
            while (true) {
                // Wait for a down press
                awaitPointerEventScope {
                    awaitFirstDown(requireUnconsumed = false)
                }

                // Wait for the release
                awaitPointerEventScope {
                    waitForUpOrCancellation()
                }
            }
        }
}