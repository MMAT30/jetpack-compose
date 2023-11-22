package tor.anonymous.tipper

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import tor.anonymous.tipper.ui.theme.TipperTheme
import java.text.NumberFormat

class TipperUITests {
    @get: Rule
    val composeTestRule = createComposeRule()


    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipperTheme {
                TipperLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )

    }
}


