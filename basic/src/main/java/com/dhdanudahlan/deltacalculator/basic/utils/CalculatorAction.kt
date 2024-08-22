package com.dhdanudahlan.deltacalculator.basic.utils

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    object Clear: CalculatorAction()
    object Delete: CalculatorAction()
    object Parentheses: CalculatorAction()
    object Percent: CalculatorAction()
    object Negate: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calculate: CalculatorAction()
    object Add: CalculatorAction()
    object Subtract: CalculatorAction()
    object Multiply: CalculatorAction()
    object Divide: CalculatorAction()
}