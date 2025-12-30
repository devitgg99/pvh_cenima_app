package com.example.pvh_cenima.navigation

sealed class Screen(val route: String) {
    data object SignInScreen : Screen("sign_in_screen")
    data object SignUpScreen : Screen("sign_up_screen")
    data object HomeScreen : Screen("home_screen")
    data object ExploreScreen : Screen(" explore_screen")
    data object ListScreen : Screen("list_screen")
    data object ProfileScreen : Screen("profile_screen")
    data object SplashScreen : Screen("splash_screen")
    data object SignInSignUpScreen : Screen("signin_signup_screen")
    data object OnBoardingScreen : Screen("on_boarding_screen")
    data object OnBoardingScreen2 : Screen("on_boarding_screen2")
}