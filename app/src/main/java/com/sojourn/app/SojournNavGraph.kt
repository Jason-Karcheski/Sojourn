package com.sojourn.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sojourn.common.composable.SojournTopBar
import com.sojourn.feature.trips.navigation.trips
import com.sojourn.trips.navigation.TripsDestination

@Composable
internal fun SojournNavGraph() {
    val controller = rememberNavController()
    val currentBackStackEntry by controller.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            currentBackStackEntry?.let { DynamicTopBar(currentRoute = it) }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = controller,
            startDestination = TripsDestination.Trips
        ) {
            trips()
        }
    }
}

@Composable
private fun DynamicTopBar(currentRoute: NavBackStackEntry) {
    val destination = currentRoute.destination

    when {
        destination.hasRoute<TripsDestination.Trips>() -> {
            SojournTopBar(
                title = "Trips",
                onBackPressed = {}
            )
        }
    }
}