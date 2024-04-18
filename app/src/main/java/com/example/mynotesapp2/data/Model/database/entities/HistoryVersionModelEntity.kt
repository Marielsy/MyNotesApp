package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

@Entity(tableName = "history_version_table")
data class HistoryVersionModelEntity (
    @PrimaryKey(true)
    @ColumnInfo("id") var id : Int,
    @ColumnInfo("nota_id") var notaId: Int,
    @ColumnInfo("version") var version: Int,
    @ColumnInfo("titulo") var title: String,
    @ColumnInfo("contenido") var content: String,
    @ColumnInfo("creacion") var creation: LocalDateTime
)