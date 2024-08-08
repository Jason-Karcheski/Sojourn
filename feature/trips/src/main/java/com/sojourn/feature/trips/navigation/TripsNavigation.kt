package com.sojourn.feature.trips.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sojourn.feature.trips.TripsRoute

fun NavHostController.navigateToTrips(options: NavOptions? = null) {
    this.navigate(
        route = TripsDestination.Trips,
        navOptions = options
    )
}

fun NavGraphBuilder.trips(shouldCollapseTopBar: (Boolean) -> Unit) {
    composable<TripsDestination.Trips> {
        TripsRoute(onScrollEnded = shouldCollapseTopBar)
    }
}