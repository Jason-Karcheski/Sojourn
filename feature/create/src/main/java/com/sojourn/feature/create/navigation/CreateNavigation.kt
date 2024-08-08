package com.sojourn.feature.create.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sojourn.feature.create.CreateRoute

fun NavHostController.navigateToCreate(options: NavOptions? = null) {
    this.navigate(
        route = CreateDestination.Create,
        navOptions = options
    )
}

fun NavGraphBuilder.create() {
    composable<CreateDestination.Create> {
        CreateRoute()
    }
}

