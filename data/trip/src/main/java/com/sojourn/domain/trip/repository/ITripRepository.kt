package com.sojourn.domain.trip.repository

import com.sojourn.common.data.database.entity.TripEntity

interface ITripRepository {

    fun getAllTrips() : List<TripEntity>

    fun saveTrip(trip: TripEntity)

    fun deleteTrip(trip: TripEntity)

}