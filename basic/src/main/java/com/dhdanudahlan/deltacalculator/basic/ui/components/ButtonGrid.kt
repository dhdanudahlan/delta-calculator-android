package com.dhdanudahlan.deltacalculator.basic.ui.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.dhdanudahlan.deltacalculator.basic.utils.ButtonTypes

@Composable
fun ButtonGrid(
    buttonList: List<ButtonTypes>,
    onButtonClick: (ButtonTypes) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
    ) {
        items(buttonList.size) { index ->
            val buttonType = buttonList[index]
            CalculatorButton(
                label = buttonType.label,
                onClick = { onButtonClick(buttonType) }
            )
        }
    }
}