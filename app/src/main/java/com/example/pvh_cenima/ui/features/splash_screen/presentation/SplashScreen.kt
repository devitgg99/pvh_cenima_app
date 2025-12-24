package com.example.pvh_cenima.ui.features.splash_screen.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.R
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.theme.primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    configuration.screenHeightDp.dp

    // Animation states
    val dropOffset = remember { Animatable(-200f) }
    val backgroundScale = remember { Animatable(0f) }
    val textAlpha = remember { Animatable(0f) }
    remember { Animatable(0.5f) }

    var showExpandingBackground by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        // Phase 1: Drop the circle from top to center with bounce
        dropOffset.animateTo(
            targetValue = 0f,
            animationSpec = tween(
                durationMillis = 800,
                easing = EaseOutBounce
            )
        )

        delay(200)

        // Phase 2: Start expanding background
        showExpandingBackground = true
        backgroundScale.animateTo(
            targetValue = 30f, // Scale large enough to fill screen
            animationSpec = tween(
                durationMillis = 600,
                easing = EaseInOutCubic
            )
        )

        // Phase 3: Show text with fade and scale
        showText = true
        textAlpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 100,
                easing = EaseOutCubic
            )
        )

        // Wait and navigate
        delay(1000)
        navController.navigate(Screen.SignInSignUpScreen.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        // Expanding background circle
        if (showExpandingBackground) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .scale(backgroundScale.value)
                    .background(color = primary, shape = CircleShape)
            )
        }

        if (showText) {
            Image(
                painter = painterResource(R.drawable.pvh_cenima_logo),
                modifier = Modifier.size(250.dp),
                contentDescription = "pvh cenima logo"
            )
        }

        if (!showExpandingBackground) {
            Surface(
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = dropOffset.value.dp),
                shape = CircleShape,
                color = primary
            ) {}
        }
    }
}