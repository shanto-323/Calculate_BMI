package com.example.bmi.domain.repo

import com.example.bmi.domain.model.HistoryModel
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    fun getHistory(): Flow<List<HistoryModel>>

    suspend fun upsertHistory(historyModel: HistoryModel)

    suspend fun deleteHistory(historyModel: HistoryModel)


}