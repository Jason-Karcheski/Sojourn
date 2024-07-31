package com.sojourn.common.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.sojourn.common.annotation.ComponentPreview
import com.sojourn.common.theme.SojournTheme
import com.sojourn.common.theme.sojournColors

/**
 * Provides a section header composable using the Sojourn Design System.
 *
 * @param modifier An optional [Modifier] value.
 * @param text The [String] the header should show.
 */
@Composable
fun LazyItemScope.sectionHeader(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier.semantics { contentDescription = "List section header" },
        text = text,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.sojournColors.onBackgroundVariant
    )
}

@ComponentPreview
@Composable
private fun SojournListSectionHeaderPreview() {
    SojournTheme {
        LazyColumn {
            item {
                sectionHeader(text = "List Section Header Preview")
            }
        }
    }
}