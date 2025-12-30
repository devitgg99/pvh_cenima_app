package com.example.pvh_cenima.ui.features.auth.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.R
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.components.LanguageBottomSheet
import com.example.pvh_cenima.ui.theme.dark_primary
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary
import com.example.pvh_cenima.ui.utility.bounceClick
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun signin_signup_screen(navController: NavController) {
    val images = listOf(
        R.drawable.titanicmovie,
        R.drawable.avatar2025,
        R.drawable.thealamomovie
    )
    val pagerState = rememberPagerState(images.size)
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
    var showSheet by remember { mutableStateOf(false) }
    val haptic = rememberHapticFeedback()
    Scaffold(
        topBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(
                        R.drawable.pvh_cenima_logo,
                    ),
                    contentDescription = "Logo",
                )
                TextButton(
                    onClick = {
                        haptic.click()
                        showSheet = true
                    },
                    border = BorderStroke(
                        width = 1.dp,
                        color = secondary
                    ),
                    modifier = Modifier.height(35.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.languageicon),
                        contentDescription = "languageIcon",
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        "English",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if (isSystemInDarkTheme()) secondary else Color.Black
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                pagerState,
            ) { currentPage ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.55f)
                        .padding(horizontal = 50.dp)
                ) {
                    Image(
                        painter = painterResource(id = images[currentPage]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            Text(
                "PVHCenima hello!",
                style = MaterialTheme.typography.displayMedium
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "Enjoy your favorite movies",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { index ->
                    val isSelected = pagerState.currentPage == index
                    Spacer(Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .clip(
                                shape = CircleShape
                            )
                            .background(color = if (isSelected) primary else secondary.copy(0.2f))
                            .size(7.dp)
                    )
                }
            }
            Spacer(Modifier.height(25.dp))
            Button(
                onClick = {
                    haptic.click()
                    navController.navigate(
                        Screen.SignInScreen.route
                    )
                },
                modifier = Modifier
                    .bounceClick(0.9f)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    "Sign in",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.White
                )
            }
            Button(
                onClick = {
                    haptic.click()
                    navController.navigate(
                        Screen.SignUpScreen.route
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .bounceClick(0.9f)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = dark_primary
                ),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = secondary
                )
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    style = MaterialTheme.typography.titleSmall,
                    color = secondary
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                "By sign in or sign up, you agree to our Terms of Service\n" +
                        "and Privac y Policy",
                style = MaterialTheme.typography.bodySmall,
                color = secondary,
                textAlign = TextAlign.Center
            )
        }
    }
    if (showSheet) {
        LanguageBottomSheet(
            onDismissRequest = {
                showSheet = false
            }
        )
    }
}