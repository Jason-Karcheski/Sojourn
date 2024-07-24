package com.sojourn.domain.trip.repository

import com.sojourn.domain.trip.model.Trip

interface ITripRepository {

    fun getAllTrips() : List<Trip>

    fun saveTrip(trip: Trip)

    fun deleteTrip(trip: Trip)

}