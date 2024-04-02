package com.example.mynotesapp2.data.Model

import com.google.gson.annotations.SerializedName

data class Book(
   @SerializedName("id") var id : Int,
   @SerializedName("usuario_id") var userId: Int,
   @SerializedName("nombre") var name : String,
)