package com.sojourn.common.feature.extension

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.sojourn.common.feature.theme.R

/**
 * Set spacing equal to that of the small space value in the Sojourn Theme along the main axis.
 */
@Composable
fun Arrangement.spacedBySmall(): Arrangement.HorizontalOrVertical =
    this.spacedBy(dimensionResource(R.dimen.space_small))

/**
 * Set spacing equal to that of the small space value in the Sojourn Theme along the main axis.
 */
@Composable
fun Arrangement.spacedByMedium(): Arrangement.HorizontalOrVertical =
    this.spacedBy(dimensionResource(R.dimen.space_medium))