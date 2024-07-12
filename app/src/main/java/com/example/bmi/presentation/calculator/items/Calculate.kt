package com.example.bmi.presentation.calculator.items

import androidx.compose.ui.graphics.Color

class Calculate {

    fun calculate(
        height: Double,
        weight: Double
    ): Double {

        var meterHeight: Double = (height * 0.3048);
        var ansBMI: Double = weight / (meterHeight * meterHeight)

        return ansBMI
    }


    fun bodyState(
        body: Double
    ): String {
        val newBody = "!!"

        if (body != 0.00) {
            return if (body < 18.5) {
                "UnderWeight"
            } else if (body in 18.5..24.9) {
                "Normal"
            } else if (body in 25.0..29.9) {
                "OverWeight"
            } else {
                "Obese"
            }
        }
        return newBody
    }


    fun color(
        body: Double
    ): Color {
        val findColor = Color.Black
        if (body != 0.00) {
            return if (body < 18.5) {
                Color(0xFFFF7000)
            } else if (body in 18.5..24.9) {
                Color.Green
            } else if (body in 25.0..29.9) {
                Color(0xFFFF7000)
            } else {
                Color.Red
            }
        }
        return findColor
    }
}