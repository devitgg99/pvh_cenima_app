package com.example.pvh_cenima.ui.utility

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.hapticfeedback.HapticFeedback
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback

class HapticFeedbackManager(
    private val composeHaptic: HapticFeedback,
    private val vibrator: Vibrator
) {
    fun soft() = composeHaptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
    fun confirm() = composeHaptic.performHapticFeedback(HapticFeedbackType.LongPress)

    fun click() = performPredefined(VibrationEffect.EFFECT_CLICK)
    fun heavyClick() = performPredefined(VibrationEffect.EFFECT_HEAVY_CLICK)
    fun doubleClick() = performPredefined(VibrationEffect.EFFECT_DOUBLE_CLICK)
    fun tick() = performPredefined(VibrationEffect.EFFECT_TICK)

    private fun performPredefined(id: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && vibrator.hasVibrator()) {
            vibrator.vibrate(VibrationEffect.createPredefined(id))
        }
    }

    fun fallbackClick() {
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        50,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(50)
            }
        }
    }
}

@Composable
fun rememberHapticFeedback(): HapticFeedbackManager {
    val haptic = LocalHapticFeedback.current
    val context = LocalContext.current
    val vibrator = remember { context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator }
    return remember(haptic, vibrator) { HapticFeedbackManager(haptic, vibrator) }
}