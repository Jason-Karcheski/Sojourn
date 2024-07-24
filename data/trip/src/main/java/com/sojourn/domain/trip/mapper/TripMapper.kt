package com.sojourn.domain.trip.mapper

import com.sojourn.common.data.database.entity.TripEntity
import com.sojourn.domain.trip.model.Trip

internal fun TripEntity.toModel() : Trip =
    Trip(
        uuid = this.uid,
        name = this.name
    )

internal fun Trip.toEntity() : TripEntity =
    TripEntity(
        uid = this.uuid,
        name = this.name
    )