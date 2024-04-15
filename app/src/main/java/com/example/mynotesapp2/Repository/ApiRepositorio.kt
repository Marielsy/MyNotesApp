@file:Suppress("UNREACHABLE_CODE")

package com.example.mynotesapp2.Repository

import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.BoringLayout
import android.util.Log
import com.example.mynotesapp2.core.di.NetworkModule

import com.example.mynotesapp2.data.Model.Book
import com.example.mynotesapp2.data.Model.Category
import com.example.mynotesapp2.data.Model.HistoryVersion
import com.example.mynotesapp2.data.Model.Note
import com.example.mynotesapp2.data.Model.User
import com.example.mynotesapp2.data.Model.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

 class ApiRepositorio
    @Inject constructor()  {
     suspend fun getAllUsers1(): List<User>? {
        return try {
            withContext(Dispatchers.IO) {
                val response = NetworkModule.provideApiService(NetworkModule.provideRetrofit()).getAllUsers()
                val re = response.body() ?: emptyList()
                Log.e("ejemplo", "getAllUsers1: $re", )
                re
            }
        } catch (e: Exception) {
            // Handle the exception
            return emptyList()
        }
    }
}



