package com.sojourn.feature.trips

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
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
 * @param onScrollEnded A callback method triggered when a scroll event ends.
 */
@Composable
internal fun TripsRoute(
    viewModel: TripsScreenViewModel = hiltViewModel(),
    onScrollEnded: (Boolean) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.onEvent(TripsScreenEvent.GetTrips)
    }

    val state by viewModel.uiState.collectAsState()
    TripsScreenContent(
        state = state,
        onScrollEnded = onScrollEnded
    )
}

@Composable
private fun TripsScreenContent(
    state: TripsScreenState,
    onScrollEnded: (Boolean) -> Unit
) {
    val hasTripsError = state.tripsError != null && !state.tripsAreLoading
        
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = com.sojourn.common.theme.R.dimen.space_medium)),
        contentAlignment = Alignment.TopCenter
    ) {
        when {
            state.tripsAreLoading -> CircularProgressIndicator()
            hasTripsError ->  StatusMessage(message = "Unable to load your trips")
            else -> TripsList(
                trips = state.trips,
                onScrollEnded = onScrollEnded
            )
        }
    }
}

@Composable
private fun TripsList(
    trips: List<Trip>?,
    onScrollEnded: (Boolean) -> Unit
) {
    val scrollState = rememberLazyListState()

    LaunchedEffect(key1 = scrollState) {
        onScrollEnded(scrollState.canScrollBackward)
    }

    when (trips.isNullOrEmpty()) {
        true -> StatusMessage(message = "No trips found")
        false -> trips.let { tripsList ->
            LazyColumn(state = scrollState) {
                sojournListSection(
                    header = "This Year",
                    items = tripsList.map { trip -> trip.name }
                )
            }
        }
    }
}

@Composable
private fun StatusMessage(message: String) {
    Text(text = message)
}

@Preview(showBackground = true)
@Composable
private fun TripsScreenPreview() {
    SojournTheme {
        TripsScreenContent(
            state = TripsScreenState(
                trips = listOf(
                    Trip(name = "Trip One"),
                    Trip(name = "Trip Two")
                )
            ),
            onScrollEnded = { /* Preview - implementation not required */ }
        )
    }
}