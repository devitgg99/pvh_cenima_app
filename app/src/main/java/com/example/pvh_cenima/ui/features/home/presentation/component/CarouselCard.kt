package com.example.pvh_cenima.ui.features.home.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pvh_cenima.R
import com.example.pvh_cenima.ui.features.home.presentation.model.BannerCard
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.utility.rememberHapticFeedback

@Composable
fun CarouselCard(card: BannerCard) {
    val hapticFeedback = rememberHapticFeedback()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(card.image),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.92f)
                        )
                    )
                )
        )
        IconButton(
            onClick = {
                hapticFeedback.click()
            },
            modifier = Modifier.size(50.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = primary
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.playic),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 15.dp, start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        card.title,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        card.tag,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.staric),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = primary
                    )
                    Text(
                        card.info,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}