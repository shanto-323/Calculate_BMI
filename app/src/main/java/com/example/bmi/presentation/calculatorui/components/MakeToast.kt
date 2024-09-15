package com.example.bmi.presentation.calculatorui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


fun makeToast(
  context: Context, text: String = ""
) {
  Toast.makeText(
    context, text, Toast.LENGTH_SHORT
  ).show()
}