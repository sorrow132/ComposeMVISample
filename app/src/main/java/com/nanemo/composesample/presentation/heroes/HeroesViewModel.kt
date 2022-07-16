package com.nanemo.composesample.presentation.heroes

import androidx.compose.runtime.Stable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nanemo.composesample.common.BaseViewModel
import com.nanemo.composesample.common.EventHandler
import com.nanemo.composesample.di.AppDispatchers
import com.nanemo.composesample.di.Dispatcher
import com.nanemo.composesample.domain.HeroesRepository
import com.nanemo.composesample.utils.MockData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    private val repository: HeroesRepository,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : BaseViewModel(), EventHandler<HeroesScreenEvents> {

    private val _uiState = MutableLiveData<ScreenHeroesState>()
    val uiState: LiveData<ScreenHeroesState> = _uiState

    init {
        fetchHeroes()
    }

    override fun obtainEvent(event: HeroesScreenEvents) {
        when (event) {
            is HeroesScreenEvents.OpenHeroDetails -> heroClicked(event.hero)
            is HeroesScreenEvents.SaveChecked -> saveClicked(event.value)
        }
    }

    private fun fetchHeroes() {
        uiScope.launch(ioDispatcher) {
            _uiState.postValue(ScreenHeroesState.Loading)
            delay(2000)
            _uiState.postValue(ScreenHeroesState.Data(MockData.heroesList))
        }
    }

    private fun saveClicked(value: Boolean) {

    }

    private fun heroClicked(value: HeroState) {

    }
}

sealed class HeroesScreenEvents {
    data class OpenHeroDetails(val hero: HeroState) : HeroesScreenEvents()
    data class SaveChecked(val value: Boolean) : HeroesScreenEvents()
}

sealed class ScreenHeroesState {
    data class Data(val heroesList: List<HeroState>) : ScreenHeroesState()
    data class Error(val error: Exception) : ScreenHeroesState()
    object Loading : ScreenHeroesState()
}

@Stable
data class HeroState(
    val id: Int,
    val name: String,
    val icon: String,
    val attr: String,
    val description: String = "Hero description",
    val isSaved: Boolean = false,
    val isExpanded: Boolean = false,
    val isSelected: Boolean = false
)