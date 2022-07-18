package com.nanemo.composesample.presentation.herodetails

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HeroDetailsScreen(
    navController: NavController,
    viewModel: HeroDetailsViewModel
) {
    Text(text = "Hero Statistic Screen")
}