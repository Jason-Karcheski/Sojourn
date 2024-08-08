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
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sojourn.common.composable.SojournTopBar
import com.sojourn.feature.create.navigation.CreateDestination
import com.sojourn.feature.create.navigation.create
import com.sojourn.feature.create.navigation.navigateToCreate
import com.sojourn.feature.trips.navigation.TripsDestination
import com.sojourn.feature.trips.navigation.trips

@Composable
internal fun SojournNavGraph() {
    val controller = rememberNavController()
    var isTopBarCollapsed by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            DynamicTopBar(
                controller = controller,
                isCollapsed = isTopBarCollapsed
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = controller,
            startDestination = TripsDestination.Trips
        ) {
            create()

            trips(shouldCollapseTopBar = { isCollapsed -> isTopBarCollapsed = isCollapsed })
        }
    }
}

@Composable
private fun DynamicTopBar(
    controller: NavHostController,
    isCollapsed: Boolean
) {
    val currentBackStackEntry by controller.currentBackStackEntryAsState()
    val destination = currentBackStackEntry?.destination

    destination?.let {
        when {
            destination.hasRoute<CreateDestination.Create>() -> {
                SojournTopBar(
                    title = "Create",
                    isCollapsed = false,
                    onBackPressed = { controller.navigateUp() }
                )
            }
            destination.hasRoute<TripsDestination.Trips>() -> {
                SojournTopBar(
                    title = "Trips",
                    isCollapsed = isCollapsed,
                    actionConfig = Icons.Rounded.Add to { controller.navigateToCreate() }
                )
            }
        }
    }
}