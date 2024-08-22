package com.dhdanudahlan.deltacalculator.basic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhdanudahlan.deltacalculator.basic.ui.screens.calculator.CalculatorScreen
import com.dhdanudahlan.deltacalculator.basic.ui.theme.DeltaCalculatorTheme
import com.dhdanudahlan.deltacalculator.basic.utils.ButtonTypes
import com.dhdanudahlan.deltacalculator.basic.utils.CalculatorState
import com.dhdanudahlan.deltacalculator.basic.viewmodel.CalculatorViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun CalculatorApp(
    calculatorState: StateFlow<CalculatorState>,
    onButtonClick: (ButtonTypes) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        CalculatorScreen(
            calculatorState = calculatorState,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.surfaceContainerLowest).padding(innerPadding),
            onButtonClick = onButtonClick,
        )
    }
}

@Preview(name = "Dark Mode", showBackground = true)
@Composable
fun CalculatorAppDarkModePreview() {
    DeltaCalculatorTheme(darkTheme = true) {
        // Create a mock CalculatorState for preview purposes
        val mockCalculatorState = MutableStateFlow(CalculatorState())

        CalculatorApp(
            calculatorState = mockCalculatorState,
            onButtonClick = {}
        )
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Composable
fun CalculatorAppLightModePreview() {
    DeltaCalculatorTheme(darkTheme = false) {
        // Create a mock ViewModel for preview purposes
        val mockViewModel = viewModel<CalculatorViewModel>()
        // Create a mock CalculatorState for preview purposes
        val mockCalculatorState = MutableStateFlow(CalculatorState())

        CalculatorApp(
            calculatorState = mockCalculatorState,
            onButtonClick = {}
        )
    }
}