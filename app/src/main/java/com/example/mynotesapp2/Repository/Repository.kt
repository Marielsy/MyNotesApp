package com.example.mynotesapp2.Repository

import androidx.room.Dao
import com.example.mynotesapp2.data.Model.APIService
import com.example.mynotesapp2.data.Model.User
import retrofit2.HttpException

class Repository constructor(
     private val api: APIService,
     private val userDao: Dao
) {
     // Aquí puedes definir tus funciones y métodos
}
