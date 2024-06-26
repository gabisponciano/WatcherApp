package com.example.watcherapp.network

import com.example.watcherapp.network.models.movies
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface movieInterface {
    @GET("movie")
    suspend fun getMovies(): List<movies>
}

object MovieApi{
    val retrofitService: movieInterface by lazy {
        retrofit.create(movieInterface::class.java)
    }
}

