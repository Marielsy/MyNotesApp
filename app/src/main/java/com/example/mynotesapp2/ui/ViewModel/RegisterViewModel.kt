package com.example.mynotesapp2.ui.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.Repository.ApiRepositorio
import com.example.mynotesapp2.data.Model.NewUser
import com.example.mynotesapp2.data.Model.database.entities.UserModelEntity
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


    val creacionLiveData: MutableLiveData<String> = MutableLiveData()

    fun validateFields(email: String, password: String, confirmPassword: String): String? {
        if (email.isEmpty() || !verifyEmail(email)) {
            return "Por favor, llene los campos correctamente."
        }
        if (password.isEmpty() || !verifyPassword(password)) {
            return "Por favor, ingrese una contraseña segura"
        }
        return if (password != confirmPassword) {
            "las contraseñas no coinciden"
        } else {
            "Registro Exitoso"
        }
    }

    private suspend fun checkUserExists(email: String): Boolean {
        val response = apiService.getAllUsers()
        return if (response.isSuccessful) {
            val users = response.body()
            val resp = users?.filter { it.email == email }
            resp?.isNotEmpty() ?: false
        } else {
            false
        }
    }

    private fun verifyEmail(email: String): Boolean {
        val emailPattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        return emailPattern.matches(email)
    }

    private fun verifyPassword(password: String): Boolean {
        val passwordPattern =
            Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}$")
        return passwordPattern.matches(password)
    }

    fun registerUser(
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            val userExists = checkUserExists(email)
            if (userExists) {
                creacionLiveData.value = "El correo electrónico ya está registrado."
            } else {
                val user = repo.createUser1(NewUser(email, password))
                if (user != null) creacionLiveData.value = "registrado"
                else creacionLiveData.value = "fallo"
            }
        }
    }
}