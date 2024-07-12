package com.example.bmi.presentation.navigation

sealed class Route (val route: String){
    object CALCULATE : Route("calculate_screen")
    object DATA : Route("data_screen")
}