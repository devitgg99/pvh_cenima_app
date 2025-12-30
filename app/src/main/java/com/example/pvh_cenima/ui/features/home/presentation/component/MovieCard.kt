package com.example.pvh_cenima.ui.features.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.R
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary

@Composable
fun MovieCard() {
    Column(
        modifier = Modifier
            .height(220.dp)
            .width(150.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Image(
                painter = painterResource(R.drawable.movie10),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .width(60.dp)
                    .height(20.dp)
                    .align(Alignment.TopEnd)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(primary, secondary)
                        ),
                        shape = RoundedCornerShape(
                            bottomStart = 5.dp,
                            topEnd = 10.dp
                        )
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Series",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Aquaman 3",
            style = MaterialTheme.typography.labelLarge
        )
    }
}