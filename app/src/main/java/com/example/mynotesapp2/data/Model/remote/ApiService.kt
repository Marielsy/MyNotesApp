package com.example.mynotesapp2.data.Model.remote

import com.example.mynotesapp2.data.Model.Book
import com.example.mynotesapp2.data.Model.Category
import com.example.mynotesapp2.data.Model.HistoryVersion
import com.example.mynotesapp2.data.Model.Note
import com.example.mynotesapp2.data.Model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("usuarios")
    suspend fun getAllUsers(): List<User>
    @GET("notas")
    suspend fun getAllNotas(): List<Note>
    @GET ("historial")
    suspend fun getAllVersion(): List<HistoryVersion>
    @GET ("categorias")
    suspend fun getAllCategory(): List<Category>
    @GET ("libretas")
    suspend fun getAllLibretas(): List<Book>


    companion object {
        var retrofitService: ApiService? = null

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): ApiService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://apirest1.tecnoparaguana.org.ve/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }

}