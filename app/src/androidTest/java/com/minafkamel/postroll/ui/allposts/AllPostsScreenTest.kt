package com.minafkamel.postroll.ui.allposts

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.minafkamel.postroll.MainActivity
import com.minafkamel.postroll.MainNavigation
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AllPostsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MainNavigation()
        }
    }

    @Test
    fun shows_loading() {
        composeTestRule
            .onNodeWithText("Loading")
            .assertExists()
    }

    @Test
    fun shows_100_posts() {
        waitUntilLoaded()

        composeTestRule.onNodeWithTag(POSTS_TEST_TAG)
            .onChildren()
            .assertCountEquals(100)
    }

    @Test
    fun click_opens_details() {
        waitUntilLoaded()

        composeTestRule.onNodeWithTag(POSTS_TEST_TAG)
            .onChildren()[1]
            .performClick()

        composeTestRule.onNodeWithText("Details")
            .assertExists()
    }

    private fun waitUntilLoaded() {
        composeTestRule.waitUntil {
            composeTestRule
                .onAllNodesWithText("Loading")
                .fetchSemanticsNodes(false)
                .isEmpty()
        }
    }
}
