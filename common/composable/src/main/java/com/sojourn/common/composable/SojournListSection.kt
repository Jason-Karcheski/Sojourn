package com.sojourn.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.sojourn.common.annotation.ComponentPreview
import com.sojourn.common.theme.R
import com.sojourn.common.theme.SojournTheme
import com.sojourn.common.theme.sojournColors

/**
 * Provides a list section styled using the Sojourn Design System.
 *
 * @param header The header value for this section.
 * @param items A list of items to show in this section.
 * @param onItemClicked A callback method that is triggered when an item is clicked. Provides the label of the clicked item as an argument.
 */
fun LazyListScope.sojournListSection(
    header: String,
    items: List<String>,
    onItemClicked: ((String) -> Unit)? = null
) {
    item {
        sectionHeader(text = header)

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_small)))

        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.sojournColors.surface,
                    shape = MaterialTheme.shapes.small
                )
                .clip(MaterialTheme.shapes.small)
        ) {
            items.forEach { item ->
                ListItemContent(
                    label = item,
                    onItemClicked = onItemClicked
                )

                if (item != items.last()) HorizontalDivider(color = MaterialTheme.sojournColors.background)
            }
        }
    }
}

@Composable
private fun ListItemContent(
    label: String,
    onItemClicked: ((String) -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .semantics { contentDescription = "List item content" }
            .fillMaxWidth()
            .clickable(
                enabled = onItemClicked != null,
                role = Role.Button,
                onClick = { onItemClicked?.invoke(label) }
            )
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )

        onItemClicked?.let {
            Icon(
                modifier = Modifier.semantics { contentDescription = "List item icon" },
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                contentDescription = null,
                tint = MaterialTheme.sojournColors.onBackgroundVariant
            )
        }
    }
}

@ComponentPreview
@Composable
private fun SojournListSectionPreview() {
    SojournTheme {
        Surface(color = MaterialTheme.sojournColors.background) {
            LazyColumn(contentPadding = PaddingValues(dimensionResource(R.dimen.padding_medium))) {
                sojournListSection(
                    header = "Section Header",
                    items = listOf("Item One", "Item Two", "Item Three"),
                    onItemClicked = { /* Preview - implementation not required */ }
                )
            }
        }
    }
}
