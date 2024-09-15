package com.example.bmi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bmi.presentation.calculatorui.BmiScreen
import com.example.bmi.presentation.ui.theme.BMITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BMITheme {
        BmiScreen()
      }
    }
  }
}
