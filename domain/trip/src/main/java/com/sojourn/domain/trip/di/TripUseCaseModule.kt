package com.sojourn.domain.trip.di

import com.sojourn.domain.trip.repository.ITripRepository
import com.sojourn.domain.trip.usecase.GetAllTripsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(ViewModelComponent::class)
object TripUseCaseModule {

    @Provides
    fun providesGetAllTripsUseCase(
        tripRepository: ITripRepository
    ) : GetAllTripsUseCase = GetAllTripsUseCase(tripRepository)

    @Provides
    fun providesCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

}