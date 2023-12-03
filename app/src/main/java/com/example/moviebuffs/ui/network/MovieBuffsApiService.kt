package com.example.moviebuffs.ui.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://kareemy.github.io"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

object MovieBuffsApi {
    val retrofitService : MovieBuffsApiService by lazy {
        retrofit.create(MovieBuffsApiService::class.java)
    }
}

interface MovieBuffsApiService {
    @GET("MovieBuffs/movies.json")
    suspend fun getMovies(): List<MovieBuffsMovie>
}