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

    @POST("usuarios")
    fun registerUser(@Body user: NewUser): Call<User?>

    }




class RetrofitServiceManager @Inject constructor() {
    private lateinit var retrofitService: ApiService

  companion object {
        private lateinit var retrofitService: ApiService

        fun getInstance(): ApiService {
            if (!::retrofitService.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://apirest1.tecnoparaguana.org.ve/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService
        }
    }


}



         suspend fun getUser(): Response<List<User>?> {
            TODO("Not yet implemented")
        }     suspend fun getAllNotas(): Response<List<Note>?> {
            TODO("Not yet implemented")
        }

         suspend fun getAllVersion(): Response<List<HistoryVersion>?> {
            TODO("Not yet implemented")
        }

        suspend fun getAllCategory(): Response<List<Category>?> {
            TODO("Not yet implemented")
        }

        suspend fun getAllLibretas(): Response<List<Book>?> {
            TODO("Not yet implemented")
        }

