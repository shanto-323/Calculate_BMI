package com.example.bmi.data.local.repository

import com.example.bmi.data.local.dao.HistoryDao
import com.example.bmi.domain.model.HistoryModel
import com.example.bmi.domain.repo.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(
    private val dao: HistoryDao
) : HistoryRepository {
    override fun getHistory(): Flow<List<HistoryModel>> = dao.getAll()

    override suspend fun upsertHistory(historyModel: HistoryModel) = dao.upsertAll(historyModel)

    override suspend fun deleteHistory(historyModel: HistoryModel) = dao.delete(historyModel)
}