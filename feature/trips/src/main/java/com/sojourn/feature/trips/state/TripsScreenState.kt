package com.sojourn.feature.trips.state

import com.sojourn.domain.trip.model.Trip

data class TripsScreenState(
    val trips: List<Trip>? = null
)
