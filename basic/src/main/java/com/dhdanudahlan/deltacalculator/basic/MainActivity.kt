package com.dhdanudahlan.deltacalculator.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dhdanudahlan.deltacalculator.basic.ui.CalculatorApp
import com.dhdanudahlan.deltacalculator.basic.ui.theme.DeltaCalculatorTheme
import com.dhdanudahlan.deltacalculator.basic.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeltaCalculatorTheme {
                val viewModel: CalculatorViewModel = viewModel()

                CalculatorApp(
                    calculatorState = viewModel.state,
                    onButtonClick = viewModel::onButtonClick
                )
            }
        }
    }
}
