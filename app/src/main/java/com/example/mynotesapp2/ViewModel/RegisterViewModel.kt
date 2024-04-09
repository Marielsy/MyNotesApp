package com.example.mynotesapp2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotesapp2.Repository.ApiRepositorio
import com.example.mynotesapp2.Repository.Repository
import com.example.mynotesapp2.data.Model.remote.ApiService
import kotlinx.coroutines.launch

class RegisterViewModel(
    apiService: ApiService
): ViewModel(){


    val repositorio = ApiRepositorio(apiService)

   var usuarios = viewModelScope.launch {
        getUsers()
    }
    suspend fun getUsers(){
        repositorio.getAllUsers()
    }

    var notas = viewModelScope.launch {
        getNotas()
    }
    suspend fun getNotas(){
        repositorio.getAllNotas()
    }
    var history = viewModelScope.launch {
        getVersion()
    }
    suspend fun getVersion(){
        repositorio.getAllVersion()
    }
//terminar de crear los suspend fun de los demas endpoints aqui y en el apisrvices

}