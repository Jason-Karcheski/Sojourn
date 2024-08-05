package com.sojourn.feature.trips

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sojourn.common.composable.sojournListSection
import com.sojourn.common.theme.SojournTheme
import com.sojourn.domain.trip.model.Trip
import com.sojourn.feature.trips.state.TripsScreenState
import com.sojourn.feature.trips.state.TripsScreenViewModel
import com.sojourn.trips.state.TripsScreenEvent

/**
 * The route composable for the Trips Screen.
 *
 * @param viewModel An instance of [TripsScreenViewModel].
 */
@Composable
internal fun TripsRoute(viewModel: TripsScreenViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.onEvent(TripsScreenEvent.GetTrips)
    }

    val state by viewModel.uiState.collectAsState()
    TripsScreenContent(state = state)
}

@Composable
private fun TripsScreenContent(state: TripsScreenState) {
    LazyColumn {
        // TODO: When support for start and end dates are added introduce logic here to create a section per each year we have trips planned.
        state.trips?.let {
            sojournListSection(
                header = "This Year",
                items = state.trips.map { it.name }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TripsScreenPreview() {
    SojournTheme {
        TripsScreenContent(state = TripsScreenState(
            trips = listOf(
                Trip(name = "Trip One"),
                Trip(name = "Trip Two")
            )
        ))
    }
}