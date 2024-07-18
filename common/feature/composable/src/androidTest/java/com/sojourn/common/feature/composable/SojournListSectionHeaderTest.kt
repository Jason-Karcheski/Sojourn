package com.sojourn.common.feature.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class SojournListSectionHeaderTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun givenSojournListSectionHeader_whenHasText_shouldShowCorrectText() {
        composeTestRule.run {
            setContent()

            onNodeWithText(VALUE_TEXT)
                .assertExists("Cannot find node with text: $VALUE_TEXT")
                .assertTextEquals(VALUE_TEXT)
        }
    }

    private fun ComposeContentTestRule.setContent(text: String = VALUE_TEXT) {
        this.setContent {
            LazyColumn {
                sectionHeader(text = text)
            }
        }
    }

    private companion object {
        private const val VALUE_TEXT = "Test Header"
    }

}