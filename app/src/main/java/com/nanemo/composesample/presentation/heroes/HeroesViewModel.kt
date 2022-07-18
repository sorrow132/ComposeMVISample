package com.nanemo.composesample.presentation.heroes

import androidx.compose.runtime.Stable
import com.nanemo.composesample.common.BaseViewModel
import com.nanemo.composesample.common.EventHandler
import com.nanemo.composesample.di.AppDispatchers
import com.nanemo.composesample.di.Dispatcher
import com.nanemo.composesample.domain.HeroesRepository
import com.nanemo.composesample.utils.MockData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val repository: HeroesRepository,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel(), EventHandler<HeroesScreenEvents> {

    private val _uiState = MutableStateFlow<List<HeroState>>(emptyList())
    val uiState: StateFlow<List<HeroState>> = _uiState

    init {
        fetchHeroes()
    }

    override fun obtainEvent(event: HeroesScreenEvents) {
        when (event) {
            is HeroesScreenEvents.SaveChecked -> {}
            is HeroesScreenEvents.ItemClick -> openHeroDetails(event.hero)
            is HeroesScreenEvents.ItemLongClick -> updateSelectHeroState(event.value, event.hero)
            is HeroesScreenEvents.ItemExpandClick -> updateHeroExpandState(event.value, event.hero)
        }
    }

    private fun fetchHeroes() {
        uiScope.launch(ioDispatcher) {
            delay(2000)
            _uiState.value = MockData.heroesList
        }
    }

    private fun updateHeroExpandState(value: Boolean, hero: HeroState) {
        _uiState.value = _uiState.value.map {
            if (it.id == hero.id) {
                it.copy(isExpanded = value)
            } else {
                it
            }
        }
    }

    private fun updateSelectHeroState(value: Boolean, hero: HeroState) {
        _uiState.value = _uiState.value.map {
            if (it.id == hero.id) {
                it.copy(isSelected = value)
            } else {
                it
            }
        }
    }

    private fun openHeroDetails(hero: HeroState) {
        _uiState.value = _uiState.value.map {
            if (it.id == hero.id) {
                it.copy(heroState = ScreenState.NavigateToHeroDetails(hero))
            } else {
                it
            }
        }
    }
}

sealed class ScreenState {
    data class NavigateToHeroDetails(val hero: HeroState) : ScreenState()
    object ShowData : ScreenState()
}

sealed class HeroesScreenEvents {
    data class SaveChecked(val value: Boolean) : HeroesScreenEvents()
    data class ItemClick(val hero: HeroState) : HeroesScreenEvents()
    data class ItemLongClick(val value: Boolean, val hero: HeroState) : HeroesScreenEvents()
    data class ItemExpandClick(val value: Boolean, val hero: HeroState) : HeroesScreenEvents()
}

@Stable
data class HeroState(
    val id: Int,
    val name: String,
    val icon: String,
    val attr: String,
    val description: String = "Hero description",
    val isSaved: Boolean = false,
    val isExpanded: Boolean,
    val isSelected: Boolean,
    val heroState: ScreenState = ScreenState.ShowData
)