package com.example.bmi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bmi.presentation.calculator.BMIViewModel
import com.example.bmi.presentation.calculator.BmiCalculator
import com.example.bmi.presentation.ui.theme.BMITheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {

            }
        }
    }
}
