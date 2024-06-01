package com.example.bmi.presentation.calculator.items

sealed class UIEvent {
    data class FirstNumberChanged(var firstNumber:String) : UIEvent()
    data class SecondNumberChanged(var secondNumber:String) : UIEvent()
}