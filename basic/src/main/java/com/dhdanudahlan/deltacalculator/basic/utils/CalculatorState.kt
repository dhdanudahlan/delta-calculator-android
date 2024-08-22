package com.dhdanudahlan.deltacalculator.basic.utils

data class CalculatorState(
//    val equation: String = "12345 + 12345 - 12345 - 12345 + 12345",
//    val equation: String = "12345 + 12345 - 12345 - 12345 + 12345 + 12345 - 12345 - 12345 + 12345",
    val equation: String = "12345 + 12345 - 12345 - 12345 + 12345 + 12345 - 12345 - 12345 + 12345 + 12345 - 12345 - 12345 + 12345 + 12345 - 12345 - 12345 + 12345",
    val result: String = "12345",
    val history: MutableList<String> = mutableListOf()
)
