package com.sojourn.trips.state

import com.sojourn.domain.trip.model.Trip

data class TripsScreenState(
    val trips: List<Trip>? = null
)
