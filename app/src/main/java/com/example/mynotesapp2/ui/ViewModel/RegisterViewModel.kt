package com.example.mynotesapp2.ui.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.Repository.ApiRepositorio
import com.example.mynotesapp2.data.Model.NewUser
import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel2 @Inject constructor(
    private val apiService: ApiService, private val repo: ApiRepositorio
) : ViewModel() {
    fun getUser() {
        viewModelScope.launch {
            val response = apiService.getAllUsers()
            if (response.isSuccessful) {
                withContext(Main) {
                    Log.e("TAG", "getUser: ${response.body()}",)
                }
            }
        }
    }
    fun registerUser(
        email: String,
        password: String,
        confirmPassword: String,
        response: (String) -> Unit
    ) {
        viewModelScope.launch {
            val userExists = checkUserExists(email)/*
            Log.e("prueba", "prueba es $userExists")*/
            if (userExists) {
                response("El correo electrónico ya está registrado.")
            } else {
                val user = repo.createUser1(NewUser(email, password))
                response(if (user != null) "Exitoso" else "Fallo")
            }
        }
    }

    private suspend fun checkUserExists(email: String): Boolean {
        val response = apiService.getAllUsers()
        return if (response.isSuccessful) {
            val users = response.body()
            Log.e("test", "test $users")
            val resp = users?.filter { it.email == email }
            Log.e("test2", "test2 ${resp?.isNotEmpty()}")

            resp?.isNotEmpty() ?: false

        } else {
            false
        }
    }
    fun validateFields(email: String, password: String, confirmPassword: String): String? {
        if (email.isEmpty() || !verifyEmail(email)) {
            return "Por favor, llene los campos correctamente."
        }
        if (password.isEmpty() || !verifyPassword(password)) {
            return "Por favor, ingrese una contMraseña válida."
        }

        if (password != confirmPassword) {
            return "Las contraseñas no coinciden."
        }
        return "Registrado Exitosamente"
    }

    private fun verifyEmail(email: String): Boolean {
        val emailPattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        return emailPattern.matches(email)
    }

    private fun verifyPassword(password: String): Boolean {
        val passwordPattern =
            Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}\$")
        return passwordPattern.matches(password)
    }
}