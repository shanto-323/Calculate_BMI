package com.example.bmi.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HistoryModel")
data class HistoryModel (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,

    val bmi : String,
    val bodyState : String
)