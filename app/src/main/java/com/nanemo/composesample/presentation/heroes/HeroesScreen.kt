package com.nanemo.composesample.presentation.heroes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.nanemo.composesample.R
import com.nanemo.composesample.presentation.LoadingWheel

@Composable
fun HeroesScreen(
    navController: NavController,
    viewModel: HeroesViewModel
) {
    val uiState = viewModel.uiState.observeAsState()

    uiState.value?.let { state ->
        when (state) {
            is ScreenHeroesState.Data -> HeroesList(
                heroesList = state.heroesList,
                onItemClick = {})
            is ScreenHeroesState.Error -> {
                Error()
            }
            ScreenHeroesState.Loading -> {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    LoadingWheel(contentDesc = "LoadingWheel")
                }
            }
        }
    }
}

@Composable
fun HeroesList(heroesList: List<HeroState>, onItemClick: () -> Unit) {
    LazyColumn {
        items(heroesList) { hero ->
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                HeroCard(
                    hero = hero,
                    onItemClick = onItemClick,
                    {}
                )
            }

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


