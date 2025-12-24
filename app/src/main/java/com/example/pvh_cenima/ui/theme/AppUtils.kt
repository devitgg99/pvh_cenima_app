package com.example.pvh_cenima.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.luminance
import com.example.pvh_cenima.common.constant.UserSession
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppUtils(
    appDimens: Dimens,
    content: @Composable () -> Unit
) {

    val appDimens = remember {
        appDimens
    }
    CompositionLocalProvider(LocalAppDimens provides appDimens) {
        content()
    }
}

val LocalAppDimens = compositionLocalOf {
    CompactLargeDimens
}


@Composable
fun isAppDarkTheme(): Boolean {
    return when (UserSession.getThemeMode()) {
        "System" -> isSystemInDarkTheme()
        "Light" -> false
        "Dark" -> true
        else -> isSystemInDarkTheme()
    }
}

@Composable
fun SetSystemBarsColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colorScheme.background.luminance() > 0.5
    val color = MaterialTheme.colorScheme.background

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = useDarkIcons
        )
    }
}

val MaterialTheme.appDimens
    @Composable
    get() = LocalAppDimens.current