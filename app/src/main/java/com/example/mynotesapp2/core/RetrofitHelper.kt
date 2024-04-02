package com.example.mynotesapp2.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://apirest1.tecnoparaguana.org.ve/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}