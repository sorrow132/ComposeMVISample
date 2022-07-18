package com.nanemo.composesample.presentation.heroes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nanemo.composesample.R

@Composable
fun HeroesScreen(
    navController: NavController,
    viewModel: HeroesViewModel
) {
    val uiState = viewModel.uiState.collectAsState()

    HeroesList(viewModel = viewModel, heroesList = uiState.value)
}

@Composable
fun HeroesList(
    viewModel: HeroesViewModel,
    heroesList: List<HeroState>
) {
    LazyColumn {
        items(items = heroesList) { hero ->
            HeroCard(
                hero = hero,
                onItemClick = {
                    viewModel.obtainEvent(
                        HeroesScreenEvents.ItemClick(it)
                    )
                },
                onLongClick = {
                    viewModel.obtainEvent(
                        HeroesScreenEvents.ItemLongClick(it.first, it.second)
                    )
                },
                onExpandCardClick = {
                    viewModel.obtainEvent(
                        HeroesScreenEvents.ItemExpandClick(it.first, it.second)
                    )
                }
            )
        }
    }
}

@Composable
fun Error() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error_404))
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        LottieAnimation(composition = composition)
    }
}


