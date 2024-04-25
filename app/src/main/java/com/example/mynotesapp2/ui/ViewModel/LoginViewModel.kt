package com.example.mynotesapp2.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.data.Model.User
import com.example.mynotesapp2.data.Model.database.dao.UserModelDao
import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: ApiService
    ) : ViewModel() {

    fun login(email: String, password: String, onLoginResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val response = repository.getAllUsers()
            if (response.isSuccessful) {
                val userList = response.body()
                if (userList != null) {
                    val loginSuccess = checkCredentials(userList, email, password)
                    onLoginResult(loginSuccess)
                } else {
                    onLoginResult(false)
                }
            } else {
                onLoginResult(false)
            }
        }
    }
    private fun checkCredentials(users: List<User>, email: String, password: String): Boolean {
        return users.any { user -> user.email == email && user.password == password }
    }
}
