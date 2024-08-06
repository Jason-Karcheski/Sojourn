package com.sojourn.domain.trip.repository

import com.sojourn.common.data.database.dao.TripDao
import com.sojourn.common.data.database.entity.TripEntity
import javax.inject.Inject

class TripRepository @Inject constructor(
    private val tripDao: TripDao
) : ITripRepository {

    override suspend fun getAllTrips(): List<TripEntity> = tripDao.getAll()

    override suspend fun saveTrip(trip: TripEntity) {
        tripDao.upsertTrip(trip)
    }

    override suspend fun deleteTrip(trip: TripEntity) {
        tripDao.deleteTrip(trip)
    }

}