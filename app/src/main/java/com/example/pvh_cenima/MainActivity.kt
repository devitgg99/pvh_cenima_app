package com.example.pvh_cenima

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.components.BottomBar
import com.example.pvh_cenima.ui.components.TopBar
import com.example.pvh_cenima.ui.graph.MainNavGraph
import com.example.pvh_cenima.ui.theme.Pvh_cenimaTheme
import com.example.pvh_cenima.ui.utility.LocalHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocalHelper.wrapContext(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val hideTopBar = listOf(
                Screen.SignInSignUpScreen.route,
                Screen.SplashScreen.route,
                Screen.SignInScreen.route,
                Screen.SignUpScreen.route,
                Screen.OnBoardingScreen.route,
                Screen.OnBoardingScreen2.route
            )
            Pvh_cenimaTheme {
                Scaffold(
                    topBar = {
                        if (!hideTopBar.contains(currentRoute)) {
                            TopBar()
                        }
                    },
                    bottomBar = {
                        if (!hideTopBar.contains(currentRoute)) {
                            BottomBar(navController)
                        }
                    },
                    modifier = Modifier
                        .systemBarsPadding()
                ) { innerPadding ->
                    MainNavGraph(
                        navController,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

