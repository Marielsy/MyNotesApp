package com.example.mynotesapp2.data.Model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "category_table")

data class CategoryModelEntity(
    @PrimaryKey(true)
    @ColumnInfo("id") var id : Int,
    @ColumnInfo("nombre") var name: String,

    )