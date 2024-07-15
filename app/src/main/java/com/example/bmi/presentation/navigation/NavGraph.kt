package com.example.bmi.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bmi.presentation.calculator.BmiCalculator
import com.example.bmi.presentation.data_screen.History


@Composable
fun NavGraph (
    navController: NavHostController
){
    NavHost(navController = navController , startDestination = Route.CALCULATE.route) {
        composable(Route.CALCULATE.route){
            BmiCalculator(
                navigate = {navController.navigate(Route.DATA.route)}
            )
        }
        composable(Route.DATA.route){
            History(
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}