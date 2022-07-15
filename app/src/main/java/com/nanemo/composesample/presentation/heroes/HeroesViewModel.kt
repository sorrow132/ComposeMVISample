package com.nanemo.composesample.presentation.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanemo.composesample.common.BaseViewModel
import com.nanemo.composesample.di.AppDispatchers
import com.nanemo.composesample.di.Dispatcher
import com.nanemo.composesample.domain.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val repository: HeroesRepository,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel() {

    private val mockData = listOf(
        HeroState(1, "Spider-man", "", "", isSaved = false, isSelected = false),
        HeroState(2, "Batman", "", "", isSaved = false, isSelected = false),
        HeroState(3, "Superman", "", "", isSaved = false, isSelected = false),
        HeroState(4, "Venom", "", "", isSaved = false, isSelected = false),
        HeroState(5, "Wonder woman", "", "", isSaved = false, isSelected = false),
        HeroState(6, "Thor", "", "", isSaved = false, isSelected = false),
        HeroState(7, "Loki", "", "", isSaved = false, isSelected = false),
        HeroState(8, "Iron man", "", "", isSaved = false, isSelected = false),
        HeroState(9, "Captain America", "", "", isSaved = false, isSelected = false),
    )

    private val _uiState = MutableLiveData<ScreenHeroesState>(ScreenHeroesState.Loading)
    val uiState: LiveData<ScreenHeroesState> = _uiState

    init {
        fetchHeroes()
    }

    private fun fetchHeroes() {
        uiScope.launch {
            _uiState.value = ScreenHeroesState.Loading
            delay(2000)
            _uiState.value = ScreenHeroesState.Data(mockData)
        }
    }
}

sealed interface ScreenHeroesState {
    data class Data(val heroesList: List<HeroState>) : ScreenHeroesState
    object Error : ScreenHeroesState
    object Loading : ScreenHeroesState
}

data class HeroState(
    val id: Int,
    val name: String,
    val icon: String,
    val attrs: String,
    val isSaved: Boolean = false,
    val isSelected: Boolean = false
)