package com.example.bmi.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bmi.data.dao.HistoryDao
import com.example.bmi.domain.model.HistoryModel

@Database(
    entities = [HistoryModel::class],
    version = 1,
    exportSchema = false
)
abstract class HistoryDB : RoomDatabase(){
    abstract val historyDao : HistoryDao
}