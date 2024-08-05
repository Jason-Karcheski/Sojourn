package com.sojourn.domain.trip.usecase

import com.sojourn.domain.trip.Resource
import com.sojourn.domain.trip.mapper.toModel
import com.sojourn.domain.trip.model.Trip
import com.sojourn.domain.trip.repository.ITripRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTripsUseCase @Inject constructor(
    private val tripRepository: ITripRepository
) {
    operator fun invoke() : Flow<Resource<List<Trip>>> = flow {
        emit(Resource.Loading())

        val trips = tripRepository
            .getAllTrips()
            .map { it.toModel() }

        emit(Resource.Success(trips))
    }.catch { error ->
        emit(Resource.Error(error))
    }
}