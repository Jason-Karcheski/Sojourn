package com.sojourn.domain.trip.repository

import com.sojourn.common.data.database.dao.TripDao
import com.sojourn.domain.trip.mapper.toEntity
import com.sojourn.domain.trip.mapper.toModel
import com.sojourn.domain.trip.model.Trip
import javax.inject.Inject

class TripRepository @Inject constructor(
    private val tripDao: TripDao
) : ITripRepository {

    override fun getAllTrips(): List<Trip> =
        tripDao.getAll().map { entity -> entity.toModel() }

    override fun saveTrip(trip: Trip) {
        tripDao.upsertTrip(trip.toEntity())
    }

    override fun deleteTrip(trip: Trip) {
        tripDao.deleteTrip(trip.toEntity())
    }

}