package com.nanemo.composesample.domain

import com.nanemo.composesample.data.remote.ApiService
import com.nanemo.composesample.di.AppDispatchers
import com.nanemo.composesample.di.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface HeroesRepository {
    fun getHeroesStat()
}

class HeroesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : HeroesRepository {

    override fun getHeroesStat() {

    }
}