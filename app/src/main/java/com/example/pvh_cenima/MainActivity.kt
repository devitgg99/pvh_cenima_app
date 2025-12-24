package com.example.pvh_cenima

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pvh_cenima.common.constant.UserSession
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.graph.MainNavGraph
import com.example.pvh_cenima.ui.theme.Pvh_cenimaTheme
import com.example.pvh_cenima.ui.theme.primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            rememberNavController()
            UserSession.initialize(LocalContext.current)
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            navBackStackEntry?.destination?.parent?.route
            val currentRoute = navBackStackEntry?.destination?.route
            val hideTopBar = listOf(
                Screen.SignInSignUpScreen.route,
                Screen.SplashScreen.route
            )
            Pvh_cenimaTheme {
                Scaffold(
                    topBar = {
                        if (!hideTopBar.contains(currentRoute)) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .background(
                                        color = primary
                                    )
                            ) {

                            }
                        }
                    },
                    bottomBar = {},
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) { innerPadding ->
                    MainNavGraph(
                        navController,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

