package com.sojourn.feature.trips.navigation

import kotlinx.serialization.Serializable

/**
 * A collection of destination screens available inside the :feature:trips module.
 */
sealed interface TripsDestination {
    @Serializable
    data object Trips : TripsDestination
}