package com.example.bmi.presentation.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.bmi.domain.repo.HistoryRepository
import com.example.bmi.presentation.calculator.items.Calculate
import com.example.bmi.presentation.calculator.items.UIEvent
import com.example.bmi.presentation.calculator.items.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BMIViewModel @Inject constructor(
    private val repository: HistoryRepository
) : ViewModel() {

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

        val calculate = Calculate()

        if (height != null && weight != null){
            uiState.value = uiState.value.copy(
                calculate = calculate.calculate(height, weight).toString().take(4)
            )
            uiState.value = uiState.value.copy(
                bodyState = calculate.bodyState(calculate.calculate(height,weight))
            )
            uiState.value = uiState.value.copy(
                color = calculate.color(calculate.calculate(height,weight))
            )
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


