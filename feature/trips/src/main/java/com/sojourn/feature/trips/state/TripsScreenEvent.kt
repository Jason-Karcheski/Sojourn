package com.sojourn.feature.trips.state

sealed interface TripsScreenEvent {
    data object GetTrips : TripsScreenEvent
}