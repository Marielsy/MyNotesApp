package com.example.mynotesapp2.data.Model

import com.google.gson.annotations.SerializedName

data class NewUser(
    @SerializedName("correo") val email: String,
    @SerializedName("contraseña") val password: String,
)

