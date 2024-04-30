package com.example.bmi.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {

    var uiState = mutableStateOf(UIState())

    fun onEvent(event:UIEvent){
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

        if (height != null && weight != null){
            var meterHeight : Double = (height*0.3048);
            var ansBMI = weight/(meterHeight*meterHeight)
            var ans = ansBMI.toString()
            uiState.value = uiState.value.copy(
                calculate = ans.take(5)
            )
        }else{
            uiState.value = uiState.value.copy(
                calculate = "!!"
            )
        }
    }
}