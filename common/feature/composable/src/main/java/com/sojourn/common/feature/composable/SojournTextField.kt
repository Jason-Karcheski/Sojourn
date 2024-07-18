package com.sojourn.common.feature.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.sojourn.common.feature.annotation.ComponentPreview
import com.sojourn.common.feature.theme.R
import com.sojourn.common.feature.theme.SojournTheme
import com.sojourn.common.feature.theme.sojournColors
import kotlinx.coroutines.flow.collectLatest

/**
 * A composable that provides a text input field using the Sojourn Design System.
 *
 * @param modifier An optional [Modifier] value.
 * @param value The [String] value shown in the text field.
 * @param onValueChanged A callback method that returns the new text value when the contents of the text field are changed.
 * @param placeholder A string value that is shown as a placeholder and label.
 * @param isSingleLine A [Boolean] flag that states if the text field should be single or multiline.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SojournTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChanged: (String) -> Unit,
    placeholder: String,
    isSingleLine: Boolean = true
) {
    val textFieldState = rememberTextFieldState(initialText = value)
    val textFieldInteractionSource = remember { MutableInteractionSource() }
    val isFocused by textFieldInteractionSource.collectIsFocusedAsState()

    LaunchedEffect(textFieldState) {
        textFieldState.textAsFlow()
            .collectLatest { newValue -> onValueChanged(newValue.toString()) }
    }

    BasicTextField2(
        modifier = modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
        state = textFieldState,
        interactionSource = textFieldInteractionSource,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.sojournColors.onBackground
        ),
        cursorBrush = SolidColor(MaterialTheme.sojournColors.primary),
        lineLimits = if (isSingleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.Default,
        decorator = { innerTextField ->
            Box(
                modifier = Modifier
                    .border(
                        width = if (isFocused) dimensionResource(R.dimen.border_selected) else dimensionResource(R.dimen.border_unselected),
                        color = if (isFocused) MaterialTheme.sojournColors.primary else MaterialTheme.sojournColors.onBackground,
                        shape = MaterialTheme.shapes.small
                    )
                    .clip(MaterialTheme.shapes.small)
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                AnimatedVisibility(textFieldState.text.isBlank()) {
                    Text(
                        modifier = Modifier.semantics { contentDescription = "Text field placeholder" },
                        text = "$placeholder...",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.sojournColors.onBackgroundVariant
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = dimensionResource(R.dimen.height_medium)),
                    verticalArrangement = Arrangement.spacedBy(
                        space = dimensionResource(R.dimen.space_extra_small),
                        alignment = Alignment.CenterVertically
                    ),
                ) {
                    AnimatedVisibility(textFieldState.text.isNotBlank()) {
                        Text(
                            modifier = Modifier.semantics { contentDescription = "Text field label" },
                            text = placeholder,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.sojournColors.onBackgroundVariant
                        )
                    }

                    innerTextField()
                }
            }
        }
    )
}

@ComponentPreview
@Composable
private fun SojournTextFieldWithContentPreview() {
    SojournTheme {
        Surface(color = MaterialTheme.sojournColors.background) {
            SojournTextField(
                value = "Preview Text Field",
                placeholder = "Preview Placeholder",
                onValueChanged = { /* Preview - implementation not required */ }
            )
        }
    }
}

@ComponentPreview
@Composable
private fun SojournTextFieldWithoutContentPreview() {
    SojournTheme {
        Surface(color = MaterialTheme.sojournColors.background) {
            SojournTextField(
                value = "",
                placeholder = "Preview Placeholder",
                onValueChanged = { /* Preview - implementation not required */ }
            )
        }
    }
}