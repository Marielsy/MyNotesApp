@file:Suppress("UNREACHABLE_CODE")

package com.example.mynotesapp2.core.di

import com.example.mynotesapp2.data.Model.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Singleton
  @Provides
  fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://apirest1.tecnoparaguana.org.ve/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
  }

    @Singleton
    @Provides
    fun  provideApiService(retrofit: Retrofit):ApiService {
        return retrofit.create(ApiService::class.java)
    }
}