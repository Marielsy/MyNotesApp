package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class UserModelEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: String = "0",
    @ColumnInfo("correo" ) val email: String,
    @ColumnInfo("contraseña") val password: String,
    @ColumnInfo("nombre") val name: String
 )