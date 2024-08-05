package com.sojourn.domain.trip.di

import com.sojourn.common.data.database.dao.TripDao
import com.sojourn.domain.trip.repository.ITripRepository
import com.sojourn.domain.trip.repository.TripRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TripDataModule {

    @Provides
    fun providesTripRepository(tripDao: TripDao) : ITripRepository = TripRepository(tripDao)

}