package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.model.BMIViewModel
import com.example.bmi.screens.BmiCalculator
import com.example.bmi.ui.theme.BMITheme

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
