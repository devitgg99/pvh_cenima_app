package com.example.pvh_cenima.ui.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.R
import com.example.pvh_cenima.navigation.Screen
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback

@Composable
fun onBoardingScreen(navController: NavController) {
    val movies = listOf(
        R.drawable.movie1,
        R.drawable.movie2,
        R.drawable.movie3,
        R.drawable.movie4,
        R.drawable.movie5,
        R.drawable.movie6,
        R.drawable.movie7,
    )
    val movies2 = listOf(
        R.drawable.movie8,
        R.drawable.movie9,
        R.drawable.movie10,
        R.drawable.movie11,
        R.drawable.movie12,
        R.drawable.movie13,
        R.drawable.movie14
    )
    val hapticFeedback = rememberHapticFeedback()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.basicMarquee(
            )
        ){
            repeat(movies.size){
                Card(
                    modifier = Modifier.width(150.dp).height(200.dp)
                ) {
                    Image(
                        painter = painterResource(movies[it]),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        CompositionLocalProvider(
            LocalLayoutDirection provides LayoutDirection.Rtl
        ) {
            Row(
                modifier = Modifier.basicMarquee()
            ) {
                repeat(movies2.size){
                    Card(
                        modifier = Modifier.width(150.dp).height(200.dp)
                    ) {
                        Image(
                            painter = painterResource(movies2[it]),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            "Tell us about your\n" +
                    "favorite movie genres",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            color = secondary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                navController.navigate(Screen.OnBoardingScreen2.route)
                hapticFeedback.click()
            },
            modifier = Modifier
                .fillMaxWidth().height(45.dp)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                "Next",
                color = secondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
            )
        }
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
    ) {
            Spacer(modifier = Modifier.width(50.dp).height(2.5.dp).clip(
                shape = RoundedCornerShape(15.dp)
            ).background(
                 primary
            ))
            Spacer(modifier = Modifier.width(5.dp))
            Spacer(modifier = Modifier.width(50.dp).height(2.5.dp).clip(
                shape = RoundedCornerShape(15.dp)
            ).background(
                secondary.copy(0.5f)
            ))
        }
    }
}