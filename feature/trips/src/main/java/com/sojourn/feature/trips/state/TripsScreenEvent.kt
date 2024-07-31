package com.sojourn.trips.state

sealed interface TripsScreenEvent {
    data object GetTrips : TripsScreenEvent
}