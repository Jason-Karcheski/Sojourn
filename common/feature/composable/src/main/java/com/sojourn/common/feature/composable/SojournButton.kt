package com.sojourn.common.feature.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import com.sojourn.common.feature.annotation.ComponentPreview
import com.sojourn.common.feature.theme.R
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors

/**
 * A composable that provides a button that uses the Sojourn Design System.
 *
 * @param modifier An optional [Modifier] value.
 * @param type The type of button to show as defined in [ButtonType].
 * @param label The buttons label represented as a [String].
 * @param isEnabled A [Boolean] flag that controls the enabled state of the button.
 * @param onClick A callback method that is triggered when the button is clicked.
 */
@Composable
fun SojournButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Primary,
    label: String,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    val containerColor = when (type) {
        ButtonType.Primary -> MaterialTheme.sojournColors.primary
        ButtonType.Secondary -> MaterialTheme.sojournColors.background
    }
    val contentColor = when (type) {
        ButtonType.Primary -> MaterialTheme.sojournColors.onPrimary
        ButtonType.Secondary -> MaterialTheme.sojournColors.onBackground
    }

    Button(
        modifier = modifier
            .fillMaxWidth()
            .semantics { contentDescription = "Button" },
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = MaterialTheme.shapes.large,
        contentPadding = PaddingValues(dimensionResource(R.dimen.space_medium)),
        enabled = isEnabled
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

sealed interface ButtonType {
    data object Primary: ButtonType
    data object Secondary: ButtonType
}

@ComponentPreview
@Composable
private fun PrimaryButtonPreview() {
    SojournTheme {
        SojournButton(label = "Primary Button") { /* Preview - implementation not required */ }
    }
}

@ComponentPreview
@Composable
private fun SecondaryButtonPreview() {
    SojournTheme {
        SojournButton(
            type = ButtonType.Secondary,
            label = "Secondary Button"
        ) { /* Preview - implementation not required */ }
    }
}