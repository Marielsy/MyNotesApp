@file:Suppress("UNREACHABLE_CODE")

package com.example.mynotesapp2.Repository

import android.util.Log
import com.example.mynotesapp2.core.di.NetworkModule
import com.example.mynotesapp2.data.Model.NewUser

import com.example.mynotesapp2.data.Model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import javax.inject.Inject

class ApiRepositorio @Inject constructor() {

    suspend fun createUser1(user: NewUser): User? {
        return try {
                val response = NetworkModule.provideApiService(NetworkModule.provideRetrofit()).registerUser(user).awaitResponse()
                if (response.isSuccessful) {
                    Log.e("TAG", "createUser1: ${response.body()}", )
                    response.body() // Retorna el usuario creado si la solicitud fue exitosa
                } else {
                    Log.e("ApiRepositorio", "Error al crear usuario: ${response.code()}")
                    null
                }
        } catch (e: Exception) {
            // Manejar excepciones de red u otros errores
            Log.e("ApiRepositorio", "Error al crear usuario: ${e.message}")
            null
        }
    }
}



