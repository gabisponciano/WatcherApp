package com.example.watcherapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.http.Header

private const val BASE_URL = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1"
private const val AUTENTICATION = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzZTY3MjU5M2JkYTE1MmJjM2YzNDRhYTMwZDFjZDg3NyIsIm5iZiI6MTcxOTQxMTc1NC4zNzY2OSwic3ViIjoiNjY3OWMyNzJkN2Y5NjU1NTAwOTA1MmQ1Iiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.0B7S8fAH1dG1HL1BettB4C8q7YlXptHCFTrfICpH7-M"

// Cria um objeto Retrofit.
// Retrofit tem um ScalarsConverter com suporte para strings e outros tipos primitivos.
// para fazer a conversao de Json para Kotlin
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    // parei aqui
    //.addHeader("accept", "application/json")
    //.addHeader("Authorization", AUTENTICATION)

    .baseUrl(BASE_URL)
    .build()



// Define uma interface com o nome MarsApiService, que estabelece
// como a Retrofit se comunica com o servidor da Web usando solicitações HTTP.
// função de suspensão para torná-la assíncrona e evitar o bloqueio de execução de chamada.
interface MoviesApiService {
    @GET("photos")      //endpoint
    suspend fun getPhotos(): List<MoviesPhoto>

}

// Define um objeto público com o nome MoviesApi para inicializar o serviço da Retrofit.
// Esse objeto é o Singleton público, que pode ser acessado pelo restante do app.
// Essa inicialização lenta serve para garantir que o objeto seja inicializado no primeiro uso.
// Inicialize a variável retrofitService usando o método .create() com a interface MoviesApiService.
object MoviesApi {
    val retrofitService : MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}



