package com.nanemo.composesample.presentation.heroes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController

@Composable
fun HeroesScreen(
    navController: NavController,
    viewModel: HeroesViewModel
) {
    val uiState = viewModel.uiState.observeAsState()

    uiState.value?.let { state ->
        when (state) {
            is ScreenHeroesState.Data -> {
                HeroesList(heroesList = state.heroesList)
            }
            ScreenHeroesState.Error -> {

            }
            ScreenHeroesState.Loading -> {

            }
        }
    }
}

@Composable
fun HeroesList(heroesList: List<HeroState>) {
    LazyColumn {
        items(heroesList) { hero ->
            HeroCard(hero = hero)
        }
    }
}


