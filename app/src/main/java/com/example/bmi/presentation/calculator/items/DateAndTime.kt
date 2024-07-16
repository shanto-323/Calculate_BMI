package com.example.bmi.presentation.calculator.items

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
class DateAndTime {
    private val current: LocalDateTime = LocalDateTime.now()


    private var date: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private var time: DateTimeFormatter? = DateTimeFormatter.ofPattern("HH:mm:ss")

    var getDate = current.format(date)
        private set
    var getTime = current.format(time)
        private set
}
