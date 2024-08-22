package com.dhdanudahlan.deltacalculator.basic.ui.screens.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dhdanudahlan.deltacalculator.basic.ui.components.ButtonGrid
import com.dhdanudahlan.deltacalculator.basic.ui.theme.DeltaCalculatorTheme
import com.dhdanudahlan.deltacalculator.basic.utils.ButtonTypes
import com.dhdanudahlan.deltacalculator.basic.utils.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

val buttonList = listOf(
    ButtonTypes.Clear, ButtonTypes.Parentheses, ButtonTypes.Percent, ButtonTypes.Divide,
    ButtonTypes.Seven, ButtonTypes.Eight, ButtonTypes.Nine, ButtonTypes.Multiply,
    ButtonTypes.Four, ButtonTypes.Five, ButtonTypes.Six, ButtonTypes.Subtract,
    ButtonTypes.One, ButtonTypes.Two, ButtonTypes.Three, ButtonTypes.Add,
    ButtonTypes.Negate, ButtonTypes.Zero, ButtonTypes.Decimal, ButtonTypes.Calculate,
)
val topButtonList = listOf(
    ButtonTypes.History, ButtonTypes.Scientific, ButtonTypes.Delete
)

@Composable
fun CalculatorScreen(
    calculatorState: StateFlow<CalculatorState>,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onButtonClick: (ButtonTypes) -> Unit
) {

    val fontSizeFinal = 20.sp

    // Collect state from ViewModel
    val state = calculatorState.collectAsState()

    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Display equation
            Text(
                text = state.value.equation,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                fontWeight = FontWeight.Light,
                fontSize = fontSizeFinal,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 3,
                style = LocalTextStyle.current.copy(lineHeight = 34.sp)
            )

            // Display result
            Text(
                text = state.value.result,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = fontSizeFinal,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
            )

            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Button A at index 0
                IconButton(
                    onClick = { onButtonClick(topButtonList[0]) },
                    modifier = Modifier
                        .padding(buttonSpacing)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    if (topButtonList[0].icon != null) {
                        Icon(imageVector = topButtonList[0].icon!!, contentDescription = topButtonList[0].label)
                    } else {
                        Text(
                            text = topButtonList[0].label,
                            fontSize = 20.sp
                        )
                    }
                }

                IconButton(
                    onClick = { onButtonClick(topButtonList[1]) },
                    modifier = Modifier
                        .padding(buttonSpacing)
                        .aspectRatio(1f)
                        .weight(1f),
                ) {
                    if (topButtonList[1].icon != null) {
                        Icon(imageVector = topButtonList[1].icon!!, contentDescription = topButtonList[1].label)
                    } else {
                        Text(
                            text = topButtonList[1].label,
                            fontSize = 20.sp
                        )
                    }
                }

                // Empty space for index 2
                Spacer(modifier = Modifier.weight(1f))

                // Empty space for index 3
                Spacer(modifier = Modifier.weight(1f))

                // Empty space for index 4
                Spacer(modifier = Modifier.weight(1f))

                // Button C at index 5
                IconButton(
                    onClick = { onButtonClick(topButtonList[2]) },
                    modifier = Modifier
                        .padding(buttonSpacing)
                        .aspectRatio(1f)
                        .weight(1f) // Adjust weight to control button width,
                ) {
                    if (topButtonList[2].icon != null) {
                        Icon(imageVector = topButtonList[2].icon!!, contentDescription = topButtonList[2].label)
                    } else {
                        Text(
                            text = topButtonList[2].label,
                            fontSize = 20.sp
                        )
                    }
                }
            }

            HorizontalDivider(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))

            ButtonGrid(
                buttonList = buttonList,
                onButtonClick = onButtonClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    DeltaCalculatorTheme {
        // Create a mock CalculatorState for preview purposes
        val mockCalculatorState = MutableStateFlow(CalculatorState())
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            CalculatorScreen(
                calculatorState = mockCalculatorState, // Example state
                modifier = Modifier.padding(innerPadding),
                onButtonClick = {}
            )
        }
    }
}