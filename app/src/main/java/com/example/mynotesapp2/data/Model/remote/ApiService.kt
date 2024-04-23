package com.example.mynotesapp2.data.Model.remote

import com.example.mynotesapp2.data.Model.Book
import com.example.mynotesapp2.data.Model.Category
import com.example.mynotesapp2.data.Model.HistoryVersion
import com.example.mynotesapp2.data.Model.NewUser
import com.example.mynotesapp2.data.Model.Note
import com.example.mynotesapp2.data.Model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject


interface ApiService {

    //hacer uno por parametros
    @GET("usuarios")
    suspend fun getAllUsers(): Response<List<User>?>

    @GET("notas")
    suspend fun getAllNotesbyIdUSer(@Query("usuario_id") idP: Int): Response<List<Note>?>




    @POST("usuarios")
    fun registerUser(@Body user: NewUser): Call<User?>


    }










