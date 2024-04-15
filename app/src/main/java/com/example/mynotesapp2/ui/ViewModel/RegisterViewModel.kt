package com.example.mynotesapp2.ui.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.Repository.ApiRepositorio
import com.example.mynotesapp2.data.Model.User
import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel2   @Inject constructor(
    private val apiRepositorio: ApiRepositorio,
    private val apiService: ApiService
): ViewModel() {

    val _users = MutableLiveData<List<User>?>()
    val users: MutableLiveData<List<User>?> = _users

    fun getUser() {
        viewModelScope.launch {
            val usersList = apiRepositorio.getAllUsers1()
            _users.value = usersList
        }
    }
    fun validateFields(email: String, password: String, confirmPassword: String): String? {
        if (email.isEmpty() || !verifyEmail(email)) {
            return "Por favor, ingrese un correo electrónico válido."
        }
        if (password.isEmpty() || !verifyPassword(password) ) {
            return "Por favor, ingrese una contraseña."
        }
        if (password != confirmPassword) {
            return "Las contraseñas no coinciden."
        }
        return null
    }
    private fun verifyEmail(email: String): Boolean {
        val emailPattern = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        return emailPattern.matches(email)
    }
    private fun verifyPassword(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#\$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?]).{8,}\$")
        return passwordPattern.matches(password)
    }

}
