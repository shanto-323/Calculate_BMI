package com.example.bmi.presentation.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.bmi.presentation.calculator.items.UIEvent
import com.example.bmi.presentation.calculator.items.UIState

class BMIViewModel : ViewModel() {

    var uiState = mutableStateOf(UIState())

    fun onEvent(event: UIEvent){
        when(event){
            is UIEvent.FirstNumberChanged -> {
                uiState.value = uiState.value.copy(
                    firstNumber = event.firstNumber
                )
            }
            is UIEvent.SecondNumberChanged -> {
                uiState.value = uiState.value.copy(
                    secondNumber = event.secondNumber
                )
            }
        }
    }

    fun calculate(){
        var height = uiState.value.firstNumber.toDoubleOrNull()
        var weight = uiState.value.secondNumber.toDoubleOrNull()

        var body:Double = 0.0

        if (height != null && weight != null){
            var meterHeight : Double = (height*0.3048);
            var ansBMI : Double  = weight/(meterHeight*meterHeight)
            body = ansBMI

            var ans = ansBMI.toString()
            uiState.value = uiState.value.copy(
                calculate = ans.take(4)
            )
            if(body != 0.00) {
                if (body < 18.5) {
                    uiState.value = uiState.value.copy(
                        bodyState = "UnderWeight"
                    )
                    uiState.value = uiState.value.copy(
                        color = Color(0xFFFF7000)
                    )
                } else if (body in 18.5 .. 24.9) {
                    uiState.value = uiState.value.copy(
                        bodyState = "Normal"
                    )
                    uiState.value = uiState.value.copy(
                        color = Color.Green
                    )
                } else if (body in 25.0..29.9) {
                    uiState.value = uiState.value.copy(
                        bodyState = "OverWeight"
                    )
                    uiState.value = uiState.value.copy(
                        color = Color(0xFFFF7000)
                    )
                } else {
                    uiState.value = uiState.value.copy(
                        bodyState = "Obese"
                    )
                    uiState.value = uiState.value.copy(
                        color = Color.Red
                    )
                }
            }
        }else{
            uiState.value = uiState.value.copy(
                calculate = "!!"
            )
        }




    }

    fun clean(){
        uiState.value = uiState.value.copy(
            calculate = ""
        )
        uiState.value = uiState.value.copy(
            bodyState = ""
        )
    }

}


