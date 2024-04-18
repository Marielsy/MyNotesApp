package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynotesapp2.data.Model.database.dao.UserModelDao

@Database(entities = [
    UserModelEntity::class,
    NoteModelEntity::class,
    HistoryVersionModelEntity::class,
    CategoryModelEntity::class,
    BookModelEntity::class
], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getUserModelDao(): UserModelDao
}
