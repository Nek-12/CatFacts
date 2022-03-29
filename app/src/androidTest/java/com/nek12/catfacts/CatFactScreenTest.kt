package com.nek12.catfacts

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nek12.catfacts.ui.screens.cat_fact.CatFactScreenContent
import com.nek12.catfacts.ui.screens.cat_fact.CatFactState.DisplayingFact
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.time.ZonedDateTime

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CatFactScreenTest {

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext(): Unit = with(composeRule) {

        setContent {
            CatFactScreenContent(state = DisplayingFact("", "Text", ZonedDateTime.now()))
        }

        onNodeWithText("Fact History").assertIsDisplayed()
    }
}
