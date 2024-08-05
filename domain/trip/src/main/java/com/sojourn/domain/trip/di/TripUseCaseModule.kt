package com.sojourn.domain.trip.di

import com.sojourn.domain.trip.repository.ITripRepository
import com.sojourn.domain.trip.usecase.GetAllTripsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object TripUseCaseModule {

    @Provides
    fun providesGetAllTripsUseCase(
        tripRepository: ITripRepository
    ) : GetAllTripsUseCase = GetAllTripsUseCase(tripRepository)

}