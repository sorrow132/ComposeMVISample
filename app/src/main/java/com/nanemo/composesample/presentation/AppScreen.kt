package com.nanemo.composesample.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nanemo.composesample.navigation.NavigationScreens
import com.nanemo.composesample.presentation.herodetails.HeroDetailsScreen
import com.nanemo.composesample.presentation.herodetails.HeroDetailsViewModel
import com.nanemo.composesample.presentation.heroes.HeroesScreen
import com.nanemo.composesample.presentation.heroes.HeroesViewModel

@Composable
fun AppScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreens.Heroes.name
    ) {

        composable(NavigationScreens.Heroes.name) {
            val heroesViewModel = hiltViewModel<HeroesViewModel>()
            HeroesScreen(
                navController = navController,
                viewModel = heroesViewModel
            )
        }

        composable(NavigationScreens.HeroDetails.name) {
            val heroDetailsViewModel = hiltViewModel<HeroDetailsViewModel>()
            HeroDetailsScreen(
                navController = navController,
                viewModel = heroDetailsViewModel
            )
        }
    }
}