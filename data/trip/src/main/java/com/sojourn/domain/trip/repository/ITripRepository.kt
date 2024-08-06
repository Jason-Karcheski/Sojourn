package com.sojourn.domain.trip.repository

import com.sojourn.common.data.database.entity.TripEntity

interface ITripRepository {

    suspend fun getAllTrips() : List<TripEntity>

    suspend fun saveTrip(trip: TripEntity)

    suspend fun deleteTrip(trip: TripEntity)

}