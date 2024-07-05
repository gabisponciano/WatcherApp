package com.example.watcherapp.network.movie

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.watcherapp.network.models.Moviee
import com.example.watcherapp.network.models.MoviesResponse
import com.example.watcherapp.network.tvShow.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface MovieUiState {
    data class Success(val result: MoviesResponse) : MovieUiState
    data object Error : MovieUiState
    data object Loading : MovieUiState

}

class MovieViewModel : ViewModel()  {
    var mediaType = "movie"

    var movieListResponse : List<Moviee> by  mutableStateOf(listOf())

    var moviesUiState: MovieUiState by mutableStateOf(MovieUiState.Loading)
        private set

    init {
        getPopularMovies(1)
    }

    fun getPopularMovies(page : Int) {
        viewModelScope.launch {
            //moviesUiState = MoviesUiState.Loading
            moviesUiState = try {
                val result =MovieApiService.RetrofitInstance.apiService.getPopularMovies(page)

                movieListResponse = result.results
                MovieUiState.Success(result)

            } catch (e: IOException) {
                MovieUiState.Error
            } catch (e: HttpException) {
                MovieUiState.Error
            }
        }
    }
}