package com.example.bmi.model

import androidx.compose.ui.graphics.Color

data class UIState (
    var firstNumber : String = "",
    var secondNumber : String = "",
    var calculate : String = "",
    var bodyState : String = "",
    var color: Color = Color.Black
)