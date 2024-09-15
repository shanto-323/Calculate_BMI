package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopPart(modifier: Modifier = Modifier) {
  Row(
    modifier
      .fillMaxWidth()
      .padding(10.dp),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = buildAnnotatedString {
        append("BMI")
        withStyle(
          style = SpanStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
          ),
        ) {
          append(" CALCULATOR")
        }
      },
      style = TextStyle(
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.Monospace,
        color = MaterialTheme.colorScheme.secondary
      ),
      modifier = Modifier
        .weight(1f)
    )
  }
  ShapeLine(color = MaterialTheme.colorScheme.secondary, strokeWidth = 2f)
}