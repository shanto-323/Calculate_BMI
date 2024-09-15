package com.example.bmi.presentation.calculatorui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayNumberButton(
  modifier: Modifier = Modifier, intNo: String, onClick: () -> Unit
) {
  Button(
    shape = RoundedCornerShape(20.dp),
    onClick = onClick,
    modifier = Modifier
      .then(modifier)
      .fillMaxSize()
      .padding(5.dp)
      .height(60.dp)
      .border(1.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(20.dp)),
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.Transparent, contentColor = MaterialTheme.colorScheme.secondary
    ),
  ) {
    Text(
      text = intNo,
      color = MaterialTheme.colorScheme.secondary,
      fontSize = 24.sp,
      modifier = Modifier.fillMaxWidth(),
      style = TextStyle(
        textAlign = TextAlign.Center
      )
    )
  }
}