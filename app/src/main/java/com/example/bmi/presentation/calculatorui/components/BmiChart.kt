package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BmiChart(
  modifier: Modifier = Modifier
) {
  val bmiChartList = mutableListOf(
    BmiChartList(
      stateName = "UnderWeight", startNumber = '<', endNumber = 18.5, color = Color.Blue
    ), BmiChartList(
      stateName = "Normal", startNumber = 18.5, endNumber = 24.9, color = Color.Green
    ), BmiChartList(
      stateName = "OverWeight", startNumber = 25.0, endNumber = 29.9, color = Color.Yellow
    ), BmiChartList(
      stateName = "Obese",
      startNumber = 30.0,
      endNumber = 34.9,
      color = MaterialTheme.colorScheme.tertiary
    ), BmiChartList(
      stateName = "Morbidly Obese", startNumber = 35.0, endNumber = '<', color = Color.Red
    )
  )

  Row(
    modifier
      .fillMaxWidth()
      .height(40.dp)
      .clip(RoundedCornerShape(10.dp))
  ) {
    bmiChartList.forEach { item ->
      Box(
        modifier
          .fillMaxHeight()
          .background(item.color.copy(alpha = 0.7f))
          .weight(1f),
        contentAlignment = Alignment.Center
      ) {
        Column(
          modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ) {
          Text(
            text = "${item.stateName}", style = TextStyle(
              fontSize = 8.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.SansSerif
            )
          )
          Text(
            text = "${item.startNumber} - ${item.endNumber}", style = TextStyle(
              fontSize = 10.sp, fontWeight = FontWeight.Bold
            )
          )
        }
      }
    }
  }
}

data class BmiChartList(
  val stateName: String = "",
  val startNumber: Any? = null,
  val endNumber: Any? = null,
  val color: Color = Color.White
)