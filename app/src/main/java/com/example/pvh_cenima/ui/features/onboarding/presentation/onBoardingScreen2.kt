package com.example.pvh_cenima.ui.features.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.navigation.Graph
import com.example.pvh_cenima.ui.features.onboarding.presentation.component.genreChip
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback

@Composable
fun onBoardingScreen2(navController: NavController) {
    val genres = listOf(
        "Action",
        "Adventure",
        "Drama",
        "Comedy",
        "Crime",
        "Documentary",
        "Sports",
        "Fantasy",
        "Horror",
        "Music",
        "Western",
        "Thriller",
        "Sci-fi"
    )
    val selectedGenres = remember { mutableStateListOf<String>() }

    val hapticFeedback = rememberHapticFeedback()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FlowRow(
            modifier = Modifier.padding(horizontal = 16.dp).height(415.dp),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically)
        ) {
            genres.forEach { genre ->
                genreChip(
                    name = genre,
                    onSelect = {
                        if (genre in selectedGenres) {
                            selectedGenres.remove(genre)
                        } else {
                            selectedGenres.add(genre)
                        }
                    },
                    isSelect = genre in selectedGenres
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            "Select thr genres you\n" +
                    "like to watch",
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
                navController.navigate(
                    Graph.AUTH_GRAPH
                )
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
            Spacer(modifier = Modifier.width(50.dp).height(2.dp).background(
                secondary.copy(0.5f)
            ))
            Spacer(modifier = Modifier.width(5.dp))
            Spacer(modifier = Modifier.width(50.dp).height(2.dp).background(
                primary
            ))
        }
    }
}