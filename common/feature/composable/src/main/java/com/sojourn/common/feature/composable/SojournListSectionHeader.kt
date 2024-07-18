package com.sojourn.common.feature.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.sojourn.common.feature.annotation.ComponentPreview
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors

/**
 * Provides a section header composable using the Sojourn Design System.
 *
 * @param text The [String] the header should show.
 */
fun LazyListScope.sectionHeader(text: String) {
    item {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.sojournColors.onBackgroundVariant
        )
    }
}

@ComponentPreview
@Composable
private fun SojournListSectionHeaderPreview() {
    SojournTheme {
        Surface(color = MaterialTheme.sojournColors.background) {
            LazyColumn {
                sectionHeader(text = "List Section Header Preview")
            }
        }
    }
}