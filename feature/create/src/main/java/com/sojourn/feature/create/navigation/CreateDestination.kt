package com.sojourn.feature.create.navigation

import kotlinx.serialization.Serializable

/**
 * A collection of destination screens available inside the :feature:create module.
 */
sealed interface CreateDestination {
    @Serializable
    data object Create: CreateDestination
}