package com.example.mynotesapp2.data.Model

import com.google.gson.annotations.SerializedName

data class Category(
   @SerializedName("id") var id : Int,
   @SerializedName("nombre") var name: String,
)