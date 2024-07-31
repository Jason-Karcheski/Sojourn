package com.sojourn.common.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class SojournListSectionTest {

    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun givenSojournListSection_whenHasHeader_shouldHaveCorrectHeader() {
        composeTestRule.run {
            setContent()

            onNodeWithContentDescription(TAG_HEADER)
                .assertExists()
                .assertTextEquals(VALUE_HEADER)
        }
    }

    @Test
    fun givenSojournListSection_whenHasItems_shouldShowCorrectItems() {
        composeTestRule.run {
            setContent()

            onNodeWithText(VALUE_ITEM_ONE).assertExists()
            onNodeWithText(VALUE_ITEM_TWO).assertExists()
        }
    }

    @Test
    fun givenSojournListSection_whenItemHasClickEvent_shouldShowIcon() {
        composeTestRule.run {
            setContent(onItemClicked = { /* Test - implementation not required */ })

            onAllNodesWithContentDescription(TAG_LIST_ITEM_ICON)[0]
                .assertExists()
        }
    }

    @Test
    fun givenSojournListSection_whenItemHasNoClickEvent_shouldHideIcon() {
        composeTestRule.run {
            setContent()

            onAllNodesWithContentDescription(TAG_LIST_ITEM_ICON)[0]
                .assertDoesNotExist()
        }
    }

    @Test
    fun givenSojournListSection_whenItemHasClickEvent_shouldTriggerEventWhenClicked() {
        composeTestRule.run {
            var counter = 0
            setContent(onItemClicked = { counter++ })

            onAllNodesWithContentDescription(TAG_LIST_ITEM_CONTENT)
                .assertAll(hasClickAction())

            onAllNodesWithContentDescription(TAG_LIST_ITEM_CONTENT)[0]
                .performClick()

            assert(counter == 1)
        }
    }

    private fun ComposeContentTestRule.setContent(
        header: String = VALUE_HEADER,
        items: List<String> = VALUE_ITEMS,
        onItemClicked: ((String) -> Unit)? = null
    ) {
        this.setContent {
            LazyColumn {
                sojournListSection(
                    header = header,
                    items = items,
                    onItemClicked = onItemClicked
                )
            }
        }
    }

    private companion object {
        private const val TAG_HEADER = "List section header"
        private const val TAG_LIST_ITEM_CONTENT = "List item content"
        private const val TAG_LIST_ITEM_ICON = "List item icon"

        private const val VALUE_HEADER = "Test Header"
        private const val VALUE_ITEM_ONE = "Item One"
        private const val VALUE_ITEM_TWO = "Item Two"
        private val VALUE_ITEMS = listOf(VALUE_ITEM_ONE, VALUE_ITEM_TWO)
    }

}