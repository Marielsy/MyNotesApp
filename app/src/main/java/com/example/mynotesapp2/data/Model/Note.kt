package com.example.mynotesapp2.data.Model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Note(
    @SerializedName ("id") val id: Int,
    @SerializedName("usuario_id") val userId: Int,
    @SerializedName("titulo")val title: String,
    @SerializedName("contenido") val content: String,
    @SerializedName("creacion") val create: LocalDateTime,
    @SerializedName ("modificacion")val modification: LocalDateTime,
    @SerializedName("etiquetas")val tags: List<Int>,
    @SerializedName("color")val color: String,
    @SerializedName ("recordatorio")val alarm: LocalDateTime?,
    @SerializedName ("compartida")val share: Boolean,
    @SerializedName("permisos")val access: List<Any>,
    @SerializedName ("libretra_id")val BookId: Int
)