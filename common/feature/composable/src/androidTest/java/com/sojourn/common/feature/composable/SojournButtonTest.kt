package com.sojourn.common.feature.composable

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SojournButtonTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun givenSojournButton_whenShown_shouldHaveCorrectLabel() {
        composeTestRule.run {
            setContent()

            onNodeWithText(VALUE_BUTTON_LABEL)
                .assertExists("Cannot find node with text: $VALUE_BUTTON_LABEL")
                .assertTextEquals(VALUE_BUTTON_LABEL)
        }
    }

    @Test
    fun givenSojournButton_whenClicked_shouldTriggerOnClick() {
        var counter = 0

        composeTestRule.run {
            setContent(onClick = { counter++ })

            onNodeWithContentDescription(TAG_BUTTON)
                .assertExists("Cannot find node with content description: $TAG_BUTTON")
                .performClick()

            assert(counter == 1)
        }
    }

    @Test
    fun givenSojournButton_whenEnabled_shouldBeEnabled() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_BUTTON)
                .assertExists("Cannot find node with content description: $TAG_BUTTON")
                .assertIsEnabled()
        }
    }

    @Test
    fun givenSojournButton_whenDisabled_shouldBeDisabled() {
        composeTestRule.run {
            setContent(isEnabled = false)

            onNodeWithContentDescription(TAG_BUTTON)
                .assertExists("Cannot find node with content description: $TAG_BUTTON")
                .assertIsNotEnabled()
        }
    }

    private fun ComposeContentTestRule.setContent(
        type: ButtonType = ButtonType.Primary,
        label: String = VALUE_BUTTON_LABEL,
        onClick: () -> Unit = { /* Test - implementation not needed by default. */ },
        isEnabled: Boolean = true
    ) {
        this.setContent {
            SojournButton(
                type = type,
                label = label,
                isEnabled = isEnabled,
                onClick = onClick
            )
        }
    }

    private companion object {
        private const val TAG_BUTTON = "Button"

        private const val VALUE_BUTTON_LABEL = "Button Label"
    }

}