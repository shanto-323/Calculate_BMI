package com.example.bmi.presentation.calculatorui.components

sealed class Event {
  data object Calculate : Event()


  data class HeightChanged(val height: String) : Event()
  data class WeightChanged(val weight: String) : Event()
}