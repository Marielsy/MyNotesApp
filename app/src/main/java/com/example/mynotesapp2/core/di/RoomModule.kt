package com.example.mynotesapp2.core.di

import android.content.Context
import androidx.room.Room
import com.example.mynotesapp2.data.Model.database.entities.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "Database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
            .build()

    @Singleton
    @Provides
    fun provideUserModelDao(db:Database)=db.getUserModelDao()
}


