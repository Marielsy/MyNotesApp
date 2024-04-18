package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book_table")
data class BookModelEntity (
    @PrimaryKey(true)
    @ColumnInfo("id") var id : Int,
    @ColumnInfo("usuario_id") var userId: Int,
    @ColumnInfo("nombre") var name : String,

    )


