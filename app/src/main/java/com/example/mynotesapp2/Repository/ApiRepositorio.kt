package com.example.mynotesapp2.Repository

import com.example.mynotesapp2.core.RetrofitHelper
import com.example.mynotesapp2.core.RetrofitHelper.getRetrofit
import com.example.mynotesapp2.data.Model.APIService
import com.example.mynotesapp2.data.Model.User
import com.example.mynotesapp2.data.Model.remote.ApiService
import retrofit2.Call

import java.time.LocalDateTime

class ApiRepositorio(
    val api : ApiService
): ApiService {


    override suspend fun getAllUsers(): List<User> {
        return api.getAllUsers()
    }

    override suspend fun getAllNotas(): List<User> {
        return api.getAllNotas()
    }
}

