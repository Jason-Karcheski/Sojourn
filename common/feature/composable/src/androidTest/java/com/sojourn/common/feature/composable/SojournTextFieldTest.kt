package com.sojourn.common.feature.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test

class SojournTextFieldTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun givenSojournTextField_whenHasNoValue_shouldShowPlaceholder() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_PLACEHOLDER)
                .assertExists("Cannot find node with content description: $TAG_PLACEHOLDER")
                .assertIsDisplayed()
        }
    }

    @Test
    fun givenSojournTextField_whenHasValue_shouldHidePlaceholder() {
        composeTestRule.run {
            setContent(value = "Fake value")

            onNodeWithContentDescription(TAG_PLACEHOLDER)
                .assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournTextField_whenHasNoValue_shouldHideLabel() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_LABEL)
                .assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournTextField_whenHasValue_shouldShowLabel() {
        composeTestRule.run {
            setContent(value = "Fake value")

            onNodeWithContentDescription(TAG_LABEL)
                .assertExists("Cannot find node with content description: $TAG_LABEL")
                .assertIsDisplayed()
        }
    }

    private fun ComposeContentTestRule.setContent(
        value: String = VALUE_DEFAULT_INPUT,
        onValueChanged: (String) -> Unit = { /* Test - implementation not required by default */ },
        placeholder: String = VALUE_PLACEHOLDER
    ) {
        this.setContent {
            SojournTextField(
                value = value,
                onValueChanged = onValueChanged,
                placeholder = placeholder,
            )
        }
    }

    private companion object {
        private const val TAG_PLACEHOLDER = "Text field placeholder"
        private const val TAG_LABEL = "Text field label"

        private const val VALUE_DEFAULT_INPUT = ""
        private const val VALUE_PLACEHOLDER = "Default placeholder"
    }

}