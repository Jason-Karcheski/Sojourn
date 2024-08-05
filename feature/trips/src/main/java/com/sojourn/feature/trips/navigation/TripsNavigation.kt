package com.sojourn.feature.trips.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sojourn.feature.trips.TripsRoute
import com.sojourn.trips.navigation.TripsDestination

fun NavHostController.navigateToTrips(options: NavOptions? = null) {
    this.navigate(
        route = TripsDestination.Trips,
        navOptions = options
    )
}

fun NavGraphBuilder.trips() {
    composable<TripsDestination.Trips> {
        TripsRoute()
    }
}