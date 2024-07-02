package com.example.watcherapp.network.movie

import com.example.watcherapp.network.data.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


data class MovieResponse(
    val results: List<Movie>
)

interface MovieApiService {
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZTY3MjU5M2JkYTE1MmJjM2YzNDRhYTMwZDFjZDg3NyIsIm5iZiI6MTcxOTQyNzUyOC41MTIyNDUsInN1YiI6IjY2NzljMjcyZDdmOTY1NTUwMDkwNTJkNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XZ8_qRfkCNvxCnwdrT-xsWOFdhbEyj_aXcKinCD7GZ4")
    @GET("movie/popular?page=1")
    suspend fun getPopularMovies(): MovieResponse





    object RetrofitInstance {
        private const val BASE_URL = "https://api.themoviedb.org/3/"

        private val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: MovieApiService by lazy {
            retrofit.create(MovieApiService::class.java)
        }
    }
}