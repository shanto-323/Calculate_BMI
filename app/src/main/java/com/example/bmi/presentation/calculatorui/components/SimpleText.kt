package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun SimpleText(
  countName: String, size: String, selected: Boolean, onClick: () -> Unit
) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = countName, style = TextStyle(
        fontSize = 18.sp,
        color = if (selected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondary,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Monospace
      )
    )

    Text(
      text = size, style = TextStyle(
        fontSize = 32.sp,
        color = if (selected) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondary,
        textAlign = TextAlign.Right
      ), modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .clickable(
          onClick = onClick
        )
    )
  }
}