package com.example.bmi.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_model")
data class HistoryModel (

    @PrimaryKey(autoGenerate = true) val id : Int = 0,

    val bmi : String,
    val bodyState : String,
    val date : String = "",
    val time : String = "",
    val color: Int = 0

)