package com.example.bmi.presentation.calculatorui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bmi.presentation.calculatorui.components.Calculate
import com.example.bmi.presentation.calculatorui.components.Event
import com.example.bmi.presentation.calculatorui.components.State


class BmiViewModel:ViewModel() {

  var state by mutableStateOf(State())
    private set

  fun onEvent(event: Event) {
    when (event) {
      Event.Calculate -> {
        bmiCalculate(state.height, state.weight)
      }
      is Event.HeightChanged -> {
        state = state.copy(
          height = event.height
        )
      }
      is Event.WeightChanged -> {
        state = state.copy(
          weight = event.weight
        )
      }
    }
  }


  private fun bmiCalculate(height:String,weight:String){
    val calculate = Calculate()
    if(height != "0" && weight != "0"){
      val ans = calculate.calculate(height.toDouble(),weight.toDouble())
      state = state.copy(
        result = ans.toString().take(4)
      )
    }else{
      println("not ok")
    }
  }
}