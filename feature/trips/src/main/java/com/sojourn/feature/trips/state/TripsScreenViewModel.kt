package com.sojourn.feature.trips.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sojourn.domain.trip.Resource
import com.sojourn.domain.trip.usecase.GetAllTripsUseCase
import com.sojourn.trips.state.TripsScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripsScreenViewModel @Inject constructor(
    private val getAllTripsUseCase: GetAllTripsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TripsScreenState())
    val uiState get() =  _uiState.asStateFlow()

    fun onEvent(event: TripsScreenEvent) {
        when (event) {
            is TripsScreenEvent.GetTrips -> getTrips()
        }
    }

    private fun getTrips() {
        viewModelScope.launch {
            getAllTripsUseCase().collect { status ->
                _uiState.update { current ->
                    when (status) {
                        is Resource.Loading -> current.copy(tripsAreLoading = true)
                        is Resource.Error -> current.copy(
                            trips = null,
                            tripsError = status.throwable,
                            tripsAreLoading = false
                        )
                        is Resource.Success -> current.copy(
                            trips = status.data,
                            tripsError = null,
                            tripsAreLoading = false
                        )
                    }
                }
            }
        }
    }

}