package com.example.watcherapp.network.movie

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watcherapp.network.data.Movie
import com.example.watcherapp.network.data.MovieSerial
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MoviesUiState {
    data class Success(val result: List<MovieSerial>) : MoviesUiState
    data object Error : MoviesUiState
    data object Loading : MoviesUiState
}

class MoviesViewModel :ViewModel() {

    var moviesUiState: MoviesUiState by mutableStateOf(MoviesUiState.Loading)
        private set
    var movieListResponse: List<MovieSerial> by mutableStateOf(listOf())

    init {
        getMoreMedias(1)
    }

    fun getMoreMedias(page : Int) {
        viewModelScope.launch {
            //moviesUiState = MoviesUiState.Loading
            moviesUiState = try {
                val result = MovieApiService.RetrofitInstance.apiService.getPopularMovies(page)
                Log.d("MoviesViewModel", "Filmes recebidos: ${result.results.size}")
                movieListResponse = result.results
                MoviesUiState.Success(result.results)

            } catch (e: IOException) {
                Log.e("MoviesViewModel", "Erro ao carregar filmes", e)
                MoviesUiState.Error
            } catch (e: HttpException) {
                MoviesUiState.Error
            }
        }
    }
}