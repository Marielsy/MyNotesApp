package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

@Entity(tableName = "notes_table")
data class NoteModelEntity(
    @PrimaryKey(  true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("usuario_id") val userId: Int,
    @ColumnInfo("titulo")val title: String,
    @ColumnInfo("contenido") val content: String,
    @ColumnInfo("creacion") val create: LocalDateTime,
    @ColumnInfo("modificacion")val modification: LocalDateTime,
    @ColumnInfo("etiquetas")val tags: List<Int>,
    @ColumnInfo("color")val color: String,
    @ColumnInfo("recordatorio")val alarm: LocalDateTime?,
    @ColumnInfo("compartida")val share: Boolean,
    @ColumnInfo("permisos")val access: List<Any>,
    @ColumnInfo("libretra_id")val BookId: Int

    )