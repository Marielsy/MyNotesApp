package com.example.mynotesapp2.Model
import java.time.LocalDateTime


data class HistoryVersion(
    val id: Int,
    val nota_id: Int,
    val version: Int,
    val titulo: String,
    val contenido: String,
    val creacion: LocalDateTime
)