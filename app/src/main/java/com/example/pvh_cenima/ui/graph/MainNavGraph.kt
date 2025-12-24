package com.example.pvh_cenima.ui.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.pvh_cenima.navigation.Graph
import com.example.pvh_cenima.ui.navextension.authGraph
import com.example.pvh_cenima.ui.navextension.splashScreenGraph

@Composable
fun MainNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Graph.Splash_GRAPH,
    ) {
        splashScreenGraph(navController = navController)
        authGraph(navController = navController)
    }
}

