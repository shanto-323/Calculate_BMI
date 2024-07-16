package com.example.bmi.di

import android.content.Context
import androidx.room.Room
import com.example.bmi.data.dao.HistoryDao
import com.example.bmi.data.network.HistoryDB
import com.example.bmi.data.repository.HistoryRepositoryImpl
import com.example.bmi.domain.repo.HistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideHistoryDB(
        @ApplicationContext
        context: Context
    )= Room.databaseBuilder(
        context,
        HistoryDB::class.java,
        "history_model"
    )
        //.addMigrations(MigrationFrom)
        .fallbackToDestructiveMigration()
        .build()



    @Provides
    fun provideHistoryDao(
        historyDB: HistoryDB
    ) = historyDB.historyDao



    @Provides
    fun provideHistoryRepository(
        historyDao: HistoryDao
    ) : HistoryRepository = HistoryRepositoryImpl(
        dao = historyDao
    )


}