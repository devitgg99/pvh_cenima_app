package com.example.pvh_cenima.navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object SplashScreen : Screen("splash_screen")
    data object SignInSignUpScreen : Screen("signin_signup_screen")
}