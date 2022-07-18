package com.nanemo.composesample.di

import com.nanemo.composesample.data.remote.ApiService
import com.nanemo.composesample.domain.HeroesRepository
import com.nanemo.composesample.domain.HeroesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
        apiService: ApiService,
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher
    ): HeroesRepository {
        return HeroesRepositoryImpl(apiService, ioDispatcher)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object DispatchersModule {
        @Provides
        @Dispatcher(AppDispatchers.IO)
        fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
    }
}