package com.example.mynotesapp2.data.Model
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime


data class HistoryVersion(
    @SerializedName("id") var id : Int,
    @SerializedName("nota_id") var notaId: Int,
    @SerializedName("version") var version: Int,
    @SerializedName("titulo") var title: String,
    @SerializedName("contenido") var content: String,
    @SerializedName("creacion") var creation: LocalDateTime
)