package com.dhdanudahlan.deltacalculator.basic.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorButton(
    label: String = "",
    onClick: () -> Unit
) {
    Box(modifier = Modifier.padding(4.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f),
            shape = CircleShape,
            contentColor = getContentColor(label) ?: MaterialTheme.colorScheme.onBackground,
            containerColor = MaterialTheme.colorScheme.background
        ) {
            Text(text = label, fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }
    }
}

fun getContentColor(label: String): Color? {
    return when (label) {
        "C", "AC" -> Color(0xFFF44336)
        "( )", "%", "÷", "×", "+", "-", "=" -> Color(0xFFFF9800)
        else -> null
    }
}