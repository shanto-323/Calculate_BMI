package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShapeLine(
  color: Color, strokeWidth: Float
) {
  Canvas(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
  ) {
    drawLine(
      start = Offset(0f, 0f), end = Offset(size.width, 0f), color = color, strokeWidth = strokeWidth
    )
  }
}