package com.example.mynotesapp2.Model

import java.time.LocalDateTime

data class Note(
    val id: Int,
    val usuario_id: Int,
    val titulo: String,
    val contenido: String,
    val creacion: LocalDateTime,
    val modificacion: LocalDateTime,
    val etiquetas: List<Int>,
    val color: String,
    val recordatorio: LocalDateTime?,
    val compartida: Boolean,
    val permisos: List<Any>,
    val libreta_id: Int
)