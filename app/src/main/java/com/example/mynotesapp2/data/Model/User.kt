package com.example.mynotesapp2.data.Model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName ("id")val id: Int,
    @SerializedName("correo")val email: String,
    @SerializedName("contraseña")val password: String,
    @SerializedName("nombre") val name: String
)