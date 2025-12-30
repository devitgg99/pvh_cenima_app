package com.example.pvh_cenima.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pvh_cenima.R
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.theme.bottomSheetColor
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback

data class BottomNavItem(
    val route: String,
    val icon: Int,
    val label: String
)

@Composable
fun BottomBar(navController: NavHostController) {
    val bottomNavItems = listOf(
        BottomNavItem(Screen.HomeScreen.route, R.drawable.homeic, "Home"),
        BottomNavItem(Screen.ExploreScreen.route, R.drawable.exploreic, "Explore"),
        BottomNavItem(Screen.ListScreen.route, R.drawable.listic, "List"),
        BottomNavItem(Screen.ProfileScreen.route, R.drawable.profileic, "Profile")
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val hapticFeedback = rememberHapticFeedback()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .background(bottomSheetColor),
        horizontalArrangement = Arrangement.SpaceEvenly,

        ) {
        bottomNavItems.forEach {
            val isSelected = currentRoute == it.route
            val color by animateColorAsState(
                if (isSelected) primary else Color.Gray
            )
            Column(
                modifier = Modifier
                    .size(60.dp)
                    .clickable(
                        indication = null, // no ripple
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        hapticFeedback.click()
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(it.icon),
                    contentDescription = null,
                    tint = color
                )
                Text(
                    text = it.label,
                    style = MaterialTheme.typography.bodySmall,
                    color = color
                )
            }

        }
    }
}