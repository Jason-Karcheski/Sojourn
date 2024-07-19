package com.sojourn.feature.trips.state

import androidx.lifecycle.ViewModel
import com.sojourn.domain.trip.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TripsScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TripsScreenState())
    val uiState get() =  _uiState.asStateFlow()

    fun onEvent(event: TripsScreenEvent) {
        when (event) {
            is TripsScreenEvent.GetTrips -> getTrips()
        }
    }

    private fun getTrips() {
        // TODO: When use case is available use that instead of dummy data.
        val dummyTrips = listOf(
            Trip(name = "Trip One"),
            Trip(name = "Trip Two")
        )

        _uiState.update { current ->
            current.copy(trips = dummyTrips)
        }
    }

}