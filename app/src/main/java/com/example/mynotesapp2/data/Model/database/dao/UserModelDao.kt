package com.example.mynotesapp2.data.Model.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynotesapp2.data.Model.database.entities.BookModelEntity
import com.example.mynotesapp2.data.Model.database.entities.CategoryModelEntity
import com.example.mynotesapp2.data.Model.database.entities.HistoryVersionModelEntity
import com.example.mynotesapp2.data.Model.database.entities.NoteModelEntity
import com.example.mynotesapp2.data.Model.database.entities.UserModelEntity

@Dao
interface UserModelDao {
    @Query("SELECT * FROM USERS_TABLE ")
    suspend fun getAllUsers(): List<UserModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(modelEntity: List<UserModelEntity>)

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes(): List<NoteModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllNotes(modelEntity: List<NoteModelEntity>)

    @Query("SELECT * FROM history_version_table")
    suspend fun getAllHistoryVersions(): List<HistoryVersionModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllHistoryVersions(modelEntity: List<HistoryVersionModelEntity>)

    @Query("SELECT * FROM category_table")
    suspend fun getAllCategories(): List<CategoryModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(modelEntity: List<CategoryModelEntity>)

    @Query("SELECT * FROM book_table")
    suspend fun getAllBooks(): List<BookModelEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(modelEntity: List<BookModelEntity>)
}
