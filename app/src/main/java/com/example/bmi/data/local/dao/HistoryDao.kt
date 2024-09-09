package com.example.bmi.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.bmi.domain.model.HistoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history_model ORDER by id DESC")
    fun getAll(): Flow<List<HistoryModel>>

    @Upsert
    suspend fun upsertAll(historyModel: HistoryModel)

    @Delete
    suspend fun delete(historyModel: HistoryModel)

}