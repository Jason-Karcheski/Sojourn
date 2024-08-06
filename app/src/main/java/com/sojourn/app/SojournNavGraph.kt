package com.sojourn.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var isTopBarCollapsed by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            currentBackStackEntry?.let {
                DynamicTopBar(
                    currentRoute = it,
                    isCollapsed = isTopBarCollapsed
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = controller,
            startDestination = TripsDestination.Trips
        ) {
            trips(shouldCollapseTopBar = { isCollapsed -> isTopBarCollapsed = isCollapsed })
        }
    }
}

@Composable
private fun DynamicTopBar(
    currentRoute: NavBackStackEntry,
    isCollapsed: Boolean
) {
    val destination = currentRoute.destination

    when {
        destination.hasRoute<TripsDestination.Trips>() -> {
            SojournTopBar(
                title = "Trips",
                isCollapsed = isCollapsed,
                actionConfig = Icons.Rounded.Add to {}
            )
        }
    }
}