package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bmi.screens.BmiCalculator
import com.example.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {
                BmiCalculator()
            }
        }
    }
}
