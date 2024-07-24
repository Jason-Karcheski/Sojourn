package com.sojourn.domain.trip.di

import com.sojourn.common.data.database.dao.TripDao
import com.sojourn.domain.trip.repository.ITripRepository
import com.sojourn.domain.trip.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object TripDataModule {

    @Provides
    fun providesTripRepository(tripDao: TripDao) : ITripRepository = TripRepository(tripDao)

}