package com.sojourn.feature.create

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * The route composable for the Create Screen.
 */
@Composable
internal fun CreateRoute() {
    CreateScreenContent()
}

@Composable
private fun CreateScreenContent() {
    Text(text = "Create Screen")
}