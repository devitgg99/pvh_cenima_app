package com.example.pvh_cenima.ui.navextension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pvh_cenima.navigation.Graph
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.features.auth.presentation.signin_signup_screen
import com.example.pvh_cenima.ui.features.splash_screen.presentation.SplashScreen

fun NavGraphBuilder.splashScreenGraph(navController: NavController) {
    navigation(
        route = Graph.Splash_GRAPH,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation(
        route = Graph.AUTH_GRAPH,
        startDestination = Screen.SignInSignUpScreen.route
    ) {
        composable(
            route = Screen.SignInSignUpScreen.route
        ) {
            signin_signup_screen(navController)
        }
    }
}

