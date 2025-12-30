package com.example.pvh_cenima.ui.features.home.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pvh_cenima.R
import com.example.pvh_cenima.ui.features.home.presentation.component.CarouselCard
import com.example.pvh_cenima.ui.features.home.presentation.model.BannerCard
import com.example.pvh_cenima.ui.theme.primary
import com.example.pvh_cenima.ui.theme.secondary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val BannerItems = listOf(
        BannerCard(
            R.drawable.solotravelingmovei,
            title = "Solo Leveling",
            tag = "Anime • Action • Dark • fantasy",
            info = " 8.6 | 2025 | 13+ | 12 episodes"
        ),
        BannerCard(
            R.drawable.peakyblindermovie,
            title = "Peaky Blinders",
            tag = "Crime • Drama • Historical",
            info = " 8.8 | 2013–2022 | 18+ | 6 seasons"
        ),
        BannerCard(
            R.drawable.strangerthingmovie,
            title = "Solo Leveling",
            tag = "Anime, Action Dark fantasy",
            info = " 8.6 | 2025 | 13+ | 12 episodes"
        ),
        BannerCard(
            R.drawable.theboymovie,
            title = "The Boys",
            tag = "Action • Superhero • Dark Comedy",
            info = " 8.7 | 2019–2024 | 18+ | 4 seasons"
        )
    )
    val pagerState = rememberPagerState(BannerItems.size)
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.scrollToPage(nextPage)
        }
    }
    Column {
        HorizontalPager(
            state = pagerState
        ) { currentPage ->
            CarouselCard(BannerItems[currentPage])
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { index ->
                val isSelected = pagerState.currentPage == index
                Spacer(Modifier.width(10.dp))
                val color = animateColorAsState(
                    if (isSelected) primary else secondary.copy(0.2f)
                )
                Box(
                    modifier = Modifier
                        .clip(
                            shape = CircleShape
                        )
                        .background(color = color.value)
                        .width(if (isSelected) 35.dp else 7.dp)
                        .height(7.dp)
                )
            }
        }
    }
}