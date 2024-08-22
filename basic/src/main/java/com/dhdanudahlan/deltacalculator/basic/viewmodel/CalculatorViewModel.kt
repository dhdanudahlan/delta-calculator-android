package com.dhdanudahlan.deltacalculator.basic.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dhdanudahlan.deltacalculator.basic.utils.ButtonTypes
import com.dhdanudahlan.deltacalculator.basic.utils.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

open class CalculatorViewModel: ViewModel() {
    // Private MutableStateFlow to manage internal state
    private val _state = MutableStateFlow(CalculatorState())

    // Public StateFlow to expose the state to the UI
    val state: StateFlow<CalculatorState> = _state

    fun onButtonClick(buttonTypes: ButtonTypes) = runBlocking {
        Log.i("Clicked Button", buttonTypes.label)

        _state.update { currentState ->
            val updatedEquation = when (buttonTypes.label) {
                "C" -> ""
                "<C" -> currentState.equation.dropLast(1)
                "=" -> {
                    val result = try {
                        calculateResult(currentState.equation)
                    } catch (e: Exception) {
                        "Error"
                    }
                    result
                }
                else -> currentState.equation + buttonTypes.label
            }

            val updateResult = if (buttonTypes.label == "=") updatedEquation else currentState.result

            val updatedHistory = currentState.history
            updatedHistory.add("$updatedHistory = $updateResult")

            CalculatorState(
                equation = updatedEquation,
                result = updateResult,
                history = updatedHistory
            )
        }
    }

    private fun calculateResult(equation : String) : String{
        val context : Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable,equation,"Javascript",1,null).toString()
        if(finalResult.endsWith(".0")){
            finalResult = finalResult.replace(".0","")
        }
        return finalResult
    }
}