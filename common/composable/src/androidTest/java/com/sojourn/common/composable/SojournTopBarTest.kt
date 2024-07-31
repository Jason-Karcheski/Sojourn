package com.sojourn.common.composable

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class SojournTopBarTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun givenSojournTopBar_whenStateIsCollapsed_shouldShowCollapsedContent() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_COLLAPSED_CONTENT)
                .assertExists("Cannot find node with tag: $TAG_COLLAPSED_CONTENT")
                .assertIsDisplayed()
        }
    }

    @Test
    fun givenSojournTopBar_whenStateIsCollapsed_shouldHideExpandedContent() {
        composeTestRule.run {
            setContent()
            onNodeWithContentDescription(TAG_EXPANDED_CONTENT).assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournTopBar_whenStateIsExpanded_shouldShowExpandedContent() {
        composeTestRule.run {
            setContent(isCollapsed = false)

            onNodeWithContentDescription(TAG_EXPANDED_CONTENT)
                .assertExists("Cannot find node with tag: $TAG_EXPANDED_CONTENT")
                .assertIsDisplayed()
        }
    }

    @Test
    fun givenSojournTopBar_whenStateIsExpanded_shouldHideCollapsedContent() {
        composeTestRule.run {
            setContent(isCollapsed = false)
            onNodeWithContentDescription(TAG_COLLAPSED_CONTENT).assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournTopBar_whenBackNavigationAvailable_shouldShowBackButton() {
        composeTestRule.run {
            setContent(onBackPressed = { /* Implementation not required for UI test */ })

            onNodeWithContentDescription(TAG_BACK_BUTTON)
                .assertExists("Cannot find node with tag: $TAG_BACK_BUTTON")
                .assertIsDisplayed()
        }
    }

    @Test
    fun givenSojournTopBar_whenBackNavigationUnavailable_shouldHideBackButton() {
        composeTestRule.run {
            setContent()
            onNodeWithContentDescription(TAG_BACK_BUTTON).assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournTopBar_whenShown_shouldHaveCorrectTitle() {
        composeTestRule.run {
            setContent()

            onNodeWithText(VALUE_TITLE)
                .assertExists("Cannot find node with text: $VALUE_TITLE")
                .assertTextEquals(VALUE_TITLE)
        }
    }

    @Test
    fun givenSojournTopBar_whenHasSubTitle_shouldHaveCorrectSubtitle() {
        composeTestRule.run {
            setContent(subtitle = VALUE_SUBTITLE)

            onNodeWithText(VALUE_SUBTITLE)
                .assertExists("Cannot find node with text: $VALUE_SUBTITLE")
                .assertTextEquals(VALUE_SUBTITLE)
        }
    }

    @Test
    fun givenSojournTopBar_whenNoSubTitle_shouldShowNoSubtitle() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_SUBTITLE)
                .assertDoesNotExist()
        }
    }

    private fun ComposeContentTestRule.setContent(
        title: String = VALUE_TITLE,
        subtitle: String? = null,
        onBackPressed: (() -> Unit)? = null,
        isCollapsed: Boolean = true
    ) {
        this.setContent {
            SojournTopBar(
                title = title,
                subtitle = subtitle,
                onBackPressed = onBackPressed,
                isCollapsed = isCollapsed
            )
        }
    }

    private companion object {
        private const val TAG_BACK_BUTTON = "Top bar back button"
        private const val TAG_COLLAPSED_CONTENT = "Top bar collapsed content"
        private const val TAG_EXPANDED_CONTENT = "Top bar expanded content"
        private const val TAG_SUBTITLE = "Top bar subtitle"

        private const val VALUE_TITLE = "Top Bar Title"
        private const val VALUE_SUBTITLE = "Top Bar Subtitle"
    }
}