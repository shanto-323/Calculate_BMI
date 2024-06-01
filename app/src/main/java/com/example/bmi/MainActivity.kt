package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bmi.presentation.calculator.BMIViewModel
import com.example.bmi.presentation.calculator.BmiCalculator
import com.example.bmi.presentation.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<BMIViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {
                BmiCalculator(viewModel)
            }
        }
    }
}
