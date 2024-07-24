package com.sojourn.feature.trips.state

import androidx.lifecycle.ViewModel
import com.sojourn.domain.trip.repository.TripRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TripsScreenViewModel @Inject constructor(
    private val tripRepository: TripRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TripsScreenState())
    val uiState get() =  _uiState.asStateFlow()

    fun onEvent(event: TripsScreenEvent) {
        when (event) {
            is TripsScreenEvent.GetTrips -> getTrips()
        }
    }

    private fun getTrips() {
        _uiState.update { current ->
            current.copy(trips = tripRepository.getAllTrips())
        }
    }

}