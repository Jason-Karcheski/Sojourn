package com.sojourn.domain.trip.model

import java.util.UUID

/**
 * A Sojourn domain model that represents a user's trip.
 *
 * @param uuid A randomly generated [UUID] used as the primary ID for any trip instance.
 * @param name The trip's name.
 */
data class Trip(
    val uuid: UUID = UUID.randomUUID(),
    val name: String
)
