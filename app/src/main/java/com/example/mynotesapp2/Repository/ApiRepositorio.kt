package com.example.mynotesapp2.Repository
import android.util.Log
import com.example.mynotesapp2.core.di.NetworkModule
import com.example.mynotesapp2.data.Model.NewUser
import com.example.mynotesapp2.data.Model.User
import com.example.mynotesapp2.data.Model.database.dao.UserModelDao
import com.example.mynotesapp2.data.Model.remote.ApiService
import retrofit2.Response
import retrofit2.awaitResponse
import javax.inject.Inject

class ApiRepositorio @Inject constructor(
    val apiRetrofit: ApiService,
    private val userModelDao: UserModelDao
) {
    suspend fun createUser1(user: NewUser): User? {
        Log.e("createUser1", "createUser1")
        return try {
            val response =  apiRetrofit.registerUser(user)
                    .awaitResponse()
            if (response.isSuccessful) {
                Log.e("TAG", "createUser1: ${response.body()}",)
                response.body() // Retorna el usuario creado si la solicitud fue exitosa
            } else {
                Log.e("ApiRepositorio", "Error al crear usuario: ${response.code()}")
                null
            }
        } catch (e: Exception) {

            Log.e("ApiRepositorio", "Error al crear usuario: ${e.message}")
            null
        }
    }

    suspend fun getUser(email: String): List<User>? {
        val response =
            apiRetrofit.getAllUsers()
        return if (response.isSuccessful) {
            Log.e("TAG", "createUser1: ${response.body()}",)
            response.body() // Retorna el usuario creado si la solicitud fue exitosa
        } else {
            Log.e("ApiRepositorio", "Error al crear usuario: ${response.code()}")
            null
        }
    }
}



