package com.example.pvh_cenima.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    secondary = secondary,
    background = dark_primary
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    secondary = secondary,
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Pvh_cenimaTheme(
    activity: Activity = LocalContext.current as Activity,
    content: @Composable () -> Unit
) {
    val window = calculateWindowSizeClass(activity)
    val config = LocalConfiguration.current
    var appDimens: Dimens
    val colorScheme = if (isAppDarkTheme()) DarkColorScheme else LightColorScheme
    var typography: Typography
    when (window.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            when {
                config.screenWidthDp <= 360 -> {
                    appDimens = CompactSmallDimens
                    typography = CompactSmallTypography
                }

                config.screenWidthDp <= 420 -> {
                    appDimens = CompactMediumDimens
                    typography = CompactMediumTypography
                }

                config.screenWidthDp <= 599 -> {
                    appDimens = CompactLargeDimens
                    typography = CompactLargeTypography
                }

                else -> {
                    appDimens = MediumDimens
                    typography = MediumTypography
                }
            }
        }

        WindowWidthSizeClass.Medium -> {
            appDimens = MediumDimens
            typography = MediumTypography
        }

        WindowWidthSizeClass.Expanded -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }

        else -> {
            // fallback for unknown window size
            appDimens = CompactMediumDimens
            typography = CompactMediumTypography
        }
    }
    AppUtils(
        appDimens = appDimens
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
        ) {
            SetSystemBarsColor()
            content()
        }
    }
}