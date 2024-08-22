package com.dhdanudahlan.deltacalculator.basic.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ButtonTypes(val label: String, val color: Color, val icon: ImageVector?, val action: CalculatorAction) {
    object Clear : ButtonTypes("C", Color(0xFFF44336), Icons.Filled.Clear,
        CalculatorAction.Clear)
    object Parentheses : ButtonTypes("( )", Color.Gray, null,
        CalculatorAction.Parentheses)
    object Percent : ButtonTypes("%", Color.Gray, null,
        CalculatorAction.Percent)
    object Divide : ButtonTypes("÷", Color(0xFFFF9800), null,
        CalculatorAction.Divide)

    object Seven : ButtonTypes("7", Color(0xFF00C8C9), null,
        CalculatorAction.Number(7))
    object Eight : ButtonTypes("8", Color(0xFF00C8C9), null,
        CalculatorAction.Number(2))
    object Nine : ButtonTypes("9", Color(0xFF00C8C9), null,
        CalculatorAction.Number(3))
    object Multiply : ButtonTypes("×", Color(0xFFFF9800), null,
        CalculatorAction.Multiply)

    object Four : ButtonTypes("4", Color(0xFF00C8C9), null,
        CalculatorAction.Number(4))
    object Five : ButtonTypes("5", Color(0xFF00C8C9), null,
        CalculatorAction.Number(5))
    object Six : ButtonTypes("6", Color(0xFF00C8C9), null,
        CalculatorAction.Number(6))
    object Subtract : ButtonTypes("-", Color(0xFFFF9800), null,
        CalculatorAction.Subtract)

    object One : ButtonTypes("1", Color(0xFF00C8C9), null,
        CalculatorAction.Number(1))
    object Two : ButtonTypes("2", Color(0xFF00C8C9), null,
        CalculatorAction.Number(2))
    object Three : ButtonTypes("3", Color(0xFF00C8C9), null,
        CalculatorAction.Number(3))
    object Add : ButtonTypes("+", Color(0xFFFF9800), null,
        CalculatorAction.Add)

    object Negate : ButtonTypes("±", Color.Gray, null,
        CalculatorAction.Negate)
    object Zero : ButtonTypes("0", Color(0xFF00C8C9), null,
        CalculatorAction.Number(0))
    object Decimal : ButtonTypes(".", Color.Gray, null,
        CalculatorAction.Decimal)
    object Calculate : ButtonTypes("=", Color(0xFFFF9800), null,
        CalculatorAction.Calculate)

    object Delete : ButtonTypes("<C", Color(0xFFF44336), Icons.AutoMirrored.Outlined.Backspace,
        CalculatorAction.Delete)

    object History : ButtonTypes("H", Color.DarkGray, Icons.Outlined.AccessTime,
        CalculatorAction.Delete)
    object Scientific : ButtonTypes("Sc", Color.DarkGray, Icons.Outlined.Assessment,
        CalculatorAction.Delete)
}