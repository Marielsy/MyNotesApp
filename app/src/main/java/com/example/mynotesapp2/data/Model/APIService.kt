package com.example.mynotesapp2.data.Model
import android.service.quicksettings.Tile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.time.LocalDateTime

interface APIService {
    @GET("usuarios")
    suspend fun getUser(
        @Query ("id") id : Int,
        @Query ("correo") email: String,
        @Query ("contraseña") password: String,
        @Query ("nombre") name: String,
    )

    @GET("notas")
    suspend fun getNote(
    )
    @GET("historial")
    suspend fun getVersion(
    @Query ("id") id: Int,
    @Query ("nota_id")  notaId: Int,
    @Query ("version")  version: Int,
    @Query ("titulo")  title: String,
    @Query ("contenido")  content: String,
    @Query ("creacion")  creation: LocalDateTime,
    )
    @GET("categorias")
    suspend fun getCategory(
    @Query ("id") id: Int,
    @Query ("nombre")  name: String,
    )
    @GET("libretas")
    suspend fun getLibretas(
    @Query ("id") id: Int,
    @Query ("usuario_id") userId : Int,
    @Query ("nombre")  name: String,
    )


}