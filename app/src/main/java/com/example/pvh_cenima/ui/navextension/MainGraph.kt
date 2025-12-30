package com.example.pvh_cenima.ui.navextension

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.pvh_cenima.navigation.Graph
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.features.auth.presentation.Sign_Un_Screen
import com.example.pvh_cenima.ui.features.auth.presentation.sign_In_Screen
import com.example.pvh_cenima.ui.features.auth.presentation.signin_signup_screen
import com.example.pvh_cenima.ui.features.home.presentation.HomeScreen
import com.example.pvh_cenima.ui.features.onboarding.presentation.onBoardingScreen
import com.example.pvh_cenima.ui.features.onboarding.presentation.onBoardingScreen2
import com.example.pvh_cenima.ui.features.splash_screen.presentation.SplashScreen

fun NavGraphBuilder.splashScreenGraph(navController: NavController) {
    navigation(
        route = Graph.SPLASH_GRAPH,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(
            route = Screen.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
    }
}

fun NavGraphBuilder.onboardinggraph(navController: NavController) {
    navigation(
        route = Graph.ON_BOARDING_GRAPH,
        startDestination = Screen.OnBoardingScreen.route
    ) {
        composable(
            route = Screen.OnBoardingScreen.route
        ) {
            onBoardingScreen(navController)
        }
        composable(
            route = Screen.OnBoardingScreen2.route
        ) {
            onBoardingScreen2(navController)
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
        composable(
            route = Screen.SignInScreen.route
        ) {
            sign_In_Screen(navController)
        }
        composable(
            route = Screen.SignUpScreen.route
        ) {
            Sign_Un_Screen(navController)
        }
    }
}

fun NavGraphBuilder.featureGraph(navController: NavController) {
    navigation(
        route = Graph.FEATURE_GRAPH,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.ExploreScreen.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.ListScreen.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.ProfileScreen.route
        ) {
            HomeScreen(navController)
        }
    }
}

