package com.sojourn.common.feature.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sojourn.common.feature.extension.spacedBySmall
import com.sojourn.common.feature.theme.R
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors

/**
 * A composable that provides a Top Bar UI based on the Sojourn Design System.
 *
 * @param title The title of the [SojournTopBar].
 * @param subtitle An optional subtitle value - shown when the [SojournTopBar] collapses as the user scrolls.
 * @param onBackPressed A callback method that is triggered when the user navigates back using this [SojournTopBar] composable.
 * @param isCollapsed A [Boolean] flag that sets the collapsed/expanded state of the [SojournTopBar].
 */
@Composable
fun SojournTopBar(
    title: String,
    subtitle: String? = null,
    onBackPressed: (() -> Unit)? = null,
    isCollapsed: Boolean = true
) {
    val headingMaxLines = 1

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 64.dp)
                .padding(dimensionResource(R.dimen.padding_small)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBySmall()
        ) {
            onBackPressed?.let {
                IconButton(
                    modifier = Modifier.semantics { contentDescription = "Top bar back button" },
                    onClick = onBackPressed
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                        contentDescription = null
                    )
                }
            }

            AnimatedVisibility(isCollapsed) {
                val startPaddingResource = if (onBackPressed == null) R.dimen.padding_small else R.dimen.padding_none

                Column(
                    modifier = Modifier
                        .padding(start = dimensionResource(startPaddingResource))
                        .semantics { contentDescription = "Top bar collapsed content" }
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    subtitle?.let {
                        Text(
                            text = subtitle,
                            color = MaterialTheme.sojournColors.onBackgroundVariant,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        AnimatedVisibility(!isCollapsed) {
            Column(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.padding_none),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                    .semantics { contentDescription = "Top bar expanded content" }
            ) {
                Text(
                    modifier = Modifier.semantics { contentDescription = "Top bar title" },
                    text = title,
                    maxLines = headingMaxLines,
                    style = MaterialTheme.typography.titleLarge
                )

                subtitle?.let {
                    Text(
                        modifier = Modifier.semantics { contentDescription = "Top bar subtitle" },
                        text = subtitle,
                        color = MaterialTheme.sojournColors.onBackgroundVariant,
                        maxLines = headingMaxLines,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }

}

@Preview
@Composable
private fun SojournTopBarExpandedPreview() {
    SojournTheme {
        Surface {
            SojournTopBar(
                title = "Expanded Title",
                subtitle = "Expanded Subtitle",
                isCollapsed = false
            )
        }
    }
}

@Preview
@Composable
private fun SojournTopBarCollapsedPreview() {
    SojournTheme {
        Surface {
            SojournTopBar(
                title = "Collapsed Title",
                subtitle = "Collapsed Subtitle"
            )
        }
    }
}

